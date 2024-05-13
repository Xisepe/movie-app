package ru.ccfit.golubevm.movieapp;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.ccfit.golubevm.movieapp.core.entity.Season;
import ru.ccfit.golubevm.movieapp.core.entity.Series;
import ru.ccfit.golubevm.movieapp.core.repository.SeriesRepository;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeriesControllerTest {
    @LocalServerPort
    private Integer port;
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine")
            .withUrlParam("stringtype","unspecified");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.flyway.user",postgres::getUsername);
        registry.add("spring.flyway.password",postgres::getPassword);
        registry.add("spring.flyway.url",postgres::getJdbcUrl);
    }

    @Autowired
    SeriesRepository seriesRepository;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        seriesRepository.deleteAll();
    }

    Series getTestSeries() {
        var series = new Series();
        series.setOriginalName("test");
        var season = new Season();
        season.setOrdinal(1);
        series.setSeasons(Set.of(season));
        return series;
    }

    @Test
    void shouldGetSeriesSeason() {
        var series = seriesRepository.save(getTestSeries());
        Integer seasonId = series.getSeasons().stream().findAny().get().getId();
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/series/{id}/season/{seasonId}",series.getId(), seasonId)
                .then()
                .statusCode(200)
                .body("id", equalTo(seasonId));
    }

}
