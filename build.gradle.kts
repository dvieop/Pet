plugins {
    kotlin("jvm") version "2.1.0-Beta2"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "RiftDev"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }

    maven("https://jitpack.io") {
        name = "jitpack"
    }

    maven {
        name = "CodeMC"
        url = uri("https://repo.codemc.io/repository/maven-public/")
    }

    maven("https://repo.flyte.gg/releases")

}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("gg.flyte:twilight:1.1.15")
    implementation("com.github.SplitYoSis:ConfigSystem:3.0.8")
    implementation("com.github.SplitYoSis:CommandSystem:v1.2.7")
    implementation("com.github.SplitYoSis:MenuLib:1.17")
    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")

    testCompileOnly("org.projectlombok:lombok:1.18.34")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
    compileOnly("de.tr7zw:item-nbt-api-plugin:2.13.2")

}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
