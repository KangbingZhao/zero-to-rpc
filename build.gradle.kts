plugins {
    kotlin("jvm") version "1.7.21"
}

group = "cn.zhaokangbing"
version = "1.0-SNAPSHOT"

repositories {
    maven(url="https://maven.aliyun.com/repository/public/")
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}