import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.20"
    id("com.google.protobuf") version "0.9.4"
    id("maven-publish")
}

extra["springCloudVersion"] = "2024.0.1"


group = "traffus.common"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("com.google.protobuf:protobuf-java:3.19.1")
    implementation("io.grpc:grpc-netty-shaded:1.61.0")
    implementation("io.grpc:grpc-stub:1.61.0")
    implementation("io.grpc:grpc-protobuf:1.61.0")
}

protobuf {
    // Это правильная настройка для плагина Protobuf
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.3" // Указываем артефакт protoc
    }
    generatedFilesBaseDir = "$projectDir/generated" // Папка для сгенерированных файлов
}

sourceSets {
    main {
        java {
            srcDir("$projectDir/generated/main/java") // Путь к сгенерированным файлам
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("file://${projectDir}/build/repo")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
