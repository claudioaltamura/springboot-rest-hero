import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  java
  eclipse
  idea
  id("com.diffplug.gradle.spotless") version "3.27.1"
  id("com.github.ben-manes.versions") version "0.27.0"
  id("io.franzbecker.gradle-lombok") version "3.2.0"
  id("org.springframework.boot") version "2.2.7.RELEASE"
  id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

group = "de.claudioaltamura"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

val developmentOnly by configurations.creating
configurations {
  runtimeClasspath {
    extendsFrom(developmentOnly)
  }
    //Ist das hier notwendig?
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  compileOnly("org.projectlombok:lombok")

  annotationProcessor("org.projectlombok:lombok")

  developmentOnly("org.springframework.boot:spring-boot-devtools")

  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-web")

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}

spotless {
    java {
        googleJavaFormat()
    }
    kotlinGradle {
        ktlint()
    }
}

test {
    useJUnitPlatform()
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
    }
}
