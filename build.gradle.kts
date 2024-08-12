import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
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
    apply(plugin = "kotlin")
    group = "cn.zhaokangbing"
    version = "1.0-SNAPSHOT"

    tasks.withType<KotlinCompile> {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    repositories {
        maven(url = "https://maven.aliyun.com/repository/public/")
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.springframework.boot")
    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:${ext["springboot_version"]}")
        }
    }

}
