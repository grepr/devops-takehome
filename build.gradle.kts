plugins {
    java
    idea
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.example"
version = "1.0-SNAPSHOT"

description = """Hello World Application"""

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.dropwizard:dropwizard-core:4.0.7")
}

tasks.jar {
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "com.example.helloworld.HelloWorldApplication",
            )
        )
    }
}