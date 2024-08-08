import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("org.springframework.boot") version "3.3.2" apply false
    id("io.spring.dependency-management") version "1.1.6"
    id("org.graalvm.buildtools.native") version "0.10.2"
}



allprojects {
    apply(plugin = "io.spring.dependency-management")
    group = "cn.zhaokangbing"
    version = "1.0-SNAPSHOT"

    repositories {
        maven(url = "https://maven.aliyun.com/repository/public/")
        mavenCentral()
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:${ext["springboot_version"]}")
        }
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
}
