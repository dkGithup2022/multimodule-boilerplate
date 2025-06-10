plugins {
    `java-library`
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

dependencies {
    implementation(project(":model"))
    implementation(project(":repository"))
    implementation(project(":constant"))

    implementation("org.springframework:spring-context")
}

// bootJar 비활성화 (혹시라도 잘못 적용된 경우 대비)
tasks.register("bootJar") {
    enabled = false
}