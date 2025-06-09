
dependencies {
    implementation(project(":constant"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

tasks.named<Jar>("jar") {
    enabled = false
}