plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.flywaydb.flyway") version "10.7.1"
}

group = "ru.ccfit.golubevm"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

buildscript {
    dependencies {
        classpath("org.postgresql:postgresql:42.6.2")
        classpath("org.flywaydb:flyway-database-postgresql:10.7.1")
    }
}

repositories {
    mavenCentral()
}

flyway {
    url = "jdbc:postgresql://localhost:5432/db_project"
    user = "xisepe"
    password = "admin"
    schemas = arrayOf("public")
    cleanDisabled = false
}

dependencies {
    // https://mvnrepository.com/artifact/org.mapstruct/mapstruct
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    // https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    // https://mvnrepository.com/artifact/org.projectlombok/lombok-mapstruct-binding
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
    implementation("org.springframework.boot:spring-boot-starter-validation")



    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.flywaydb:flyway-database-postgresql:10.7.1")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
