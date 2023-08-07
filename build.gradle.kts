import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    kotlin("jvm") version "1.7.21"
    id("project-report")
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}

group = "cn.zhaokangbing"
version = "1.0-SNAPSHOT"



repositories {
    maven(url = "https://maven.aliyun.com/repository/public/")
    mavenCentral()
}

dependencyManagement {
    dependencies {
        dependency("org.springframework.boot:spring-boot-starter-web:${ext["springboot_version"]}")
        dependency("org.springframework.boot:spring-boot-starter:${ext["springboot_version"]}")
    }
}

dependencies {
    implementation(kotlin("stdlib"))
}

subprojects{
    apply(plugin="kotlin")
    apply(plugin="project-report")
    dependencies{
        implementation(enforcedPlatform(project(":")))
    }
}