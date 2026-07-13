plugins {
    id("java-library")
    id("maven-publish")
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    api("javax.annotation:javax.annotation-api:1.3.2")
    compileOnly("com.google.guava:guava:30.0-jre")
    compileOnly("net.kyori:adventure-text-minimessage:5.2.0")
    compileOnly("org.jetbrains:annotations:26.1.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-parameters")
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    repositories {
        maven {
            name = "kyngsRepo"
            url = uri(
                "https://repo.kyngs.xyz/" + (if (project.version.toString()
                        .contains("SNAPSHOT")
                ) "snapshots" else "releases") + "/"
            )
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}