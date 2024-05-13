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
import ru.ccfit.golubevm.movieapp.core.entity.CrewRole;
import ru.ccfit.golubevm.movieapp.core.repository.CrewRoleRepository;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrewRoleControllerTest {
    @LocalServerPort
    private Integer port;
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

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
    CrewRoleRepository crewRoleRepository;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        crewRoleRepository.deleteAll();
    }

    private CrewRole getCrewRole(String name) {
        var role = new CrewRole();
        role.setName(name);
        return role;
    }

    @Test
    void shouldGetRole() {
        var name = "оператор";
        var saved = crewRoleRepository.save(getCrewRole(name));
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/crew-role/" + saved.getId())
                .then()
                .statusCode(200)
                .body("name", equalTo(name));
    }
    @Test
    void shouldDeleteById() {
        var name = "оператор";
        var saved = crewRoleRepository.save(getCrewRole(name));
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/crew-role/" + saved.getId())
                .then()
                .statusCode(200);
        assertTrue(crewRoleRepository.findAll().isEmpty());
    }
}
