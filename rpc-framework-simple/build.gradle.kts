plugins {
    kotlin("jvm") version "1.7.21"
}

group = "cn.zhaokangbing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter:3.1.2")

}