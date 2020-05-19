import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.3.72"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

application {
    mainClassName = "WebAppKt"
}

group = "com.github.sithengineer"
version = "2020.1"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

dependencyManagement {
    imports {
        mavenBom("io.projectreactor:reactor-bom:Californium-RELEASE")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation("io.projectreactor.netty:reactor-netty")
    implementation("io.projectreactor:reactor-core:3.3.5.RELEASE")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.0.2.RELEASE")

    testImplementation("io.projectreactor:reactor-test:3.3.5.RELEASE")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.2")
}