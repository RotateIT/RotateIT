buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.3.RELEASE")
    }
}

repositories {
    jcenter()
    mavenCentral()
}

plugins {
    java
    application
    idea
}

apply {
    plugin("org.springframework.boot")
    from("gradle/checkstyle.gradle.kts")
    from("gradle/pmd.gradle.kts")
    from("gradle/findbugs.gradle.kts")
}

version = "0.4.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


dependencies {
    compile("org.springframework.boot:spring-boot-starter-websocket")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("com.h2database:h2")
    compile("com.google.guava:guava:22.0")

    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("pl.pojo:pojo-tester:0.7.5")
    testCompile("pl.pragmatists:JUnitParams:1.1.0")
    testCompile("org.mockito:mockito-core:2.8.47")
}

tasks {
    task<Wrapper>("wrapper") {
        gradleVersion = "4.1"
        distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
    }

    getByName("clean").doFirst {
        delete("$rootDir/classes")
    }

    withType<JavaCompile> {
        options.compilerArgs.plusAssign(listOf("-Werror", "-Xlint:all"))
    }

    getByName("bootRun").dependsOn(tasks.getByName("build"))
}
