import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") /*version "3.0.0-SNAPSHOT"*/
    id("io.spring.dependency-management") /*version "1.0.11.RELEASE"*/
    kotlin("jvm") /*version "1.6.21"*/
    kotlin("plugin.spring") /*version "1.6.21"*/
}

group = "com.nesp"
version = "1.0-SNAPSHOT"

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    maven { url = uri("https://maven.aliyun.com/nexus/content/groups/public/") }
    maven { url = uri("https://maven.aliyun.com/nexus/content/repositories/jcenter") }
    maven { url = uri("https://jitpack.io") }

    gradlePluginPortal()
    google()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(project(":nesp-sdk-kotlin"))
    implementation(project(":nesp-sdk-java"))
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<BootJar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}