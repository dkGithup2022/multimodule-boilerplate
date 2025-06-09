plugins {
    // 하위 모듈에서 사용될 수 있는 플러그인들 (apply false 로 선언만)
    java
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"

}


allprojects {
    group = "io.github.dkGithup2022.multimodule.boilerplate"  // 원하는 groupId
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}

subprojects {

    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    // 🌐 Spring BOM 전역 적용
    the<io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension>().apply {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:3.2.0")
        }
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    dependencies {
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        implementation("org.slf4j:slf4j-api")

        testCompileOnly("org.projectlombok:lombok")
        testAnnotationProcessor("org.projectlombok:lombok")
        testImplementation("org.slf4j:slf4j-api")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
