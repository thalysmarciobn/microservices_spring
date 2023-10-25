plugins {
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "com.project"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2022.0.4"

dependencies {
    implementation("io.micrometer:micrometer-tracing-bridge-brave")

    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-config:4.0.4")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-amqp")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.core:jackson-databind")

    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.flywaydb:flyway-core:8.5.5")

    implementation("io.jsonwebtoken:jjwt-root:0.11.2")
    implementation("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.2")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.2")

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.14")

    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-swagger-ui:3.0.0")

    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")

    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation(project(":shared-message"))
}

tasks.test {
    useJUnitPlatform()
}