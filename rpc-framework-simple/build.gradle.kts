import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":rpc-framework-common"))
    implementation("org.springframework.boot:spring-boot-starter")
}

tasks.named<BootJar>("bootJar") {
    enabled = false
}