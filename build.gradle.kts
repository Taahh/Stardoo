import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "dev.taah"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-all:4.1.96.Final")
    implementation(kotlin("reflect"))
    implementation("com.google.guava:guava:32.1.2-jre")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"

}