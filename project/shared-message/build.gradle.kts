plugins {
    kotlin("jvm") version "1.8.22"
}

group = "com.project"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.3")
}

tasks.test {
    useJUnitPlatform()
}