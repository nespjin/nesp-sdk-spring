import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")/* version "1.6.20"*/
}

group = "com.nesp"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/groups/public/")
    }
    maven {
        setUrl("https://maven.aliyun.com/nexus/content/repositories/jcenter")
    }

    maven { url = uri("https://jitpack.io") }
    mavenCentral()

}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}