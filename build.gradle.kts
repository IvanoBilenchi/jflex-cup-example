version = "1.0.0"
description = "A sample parser using JFlex and Cup."

repositories {
    mavenCentral()
}

plugins {
    java
    id("cup.gradle.cup-gradle-plugin") version "2.0"
    id("org.xbib.gradle.plugin.jflex") version "1.5.0"
}

tasks.jar {
    manifest.attributes("Main-Class" to "example.Main")
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}
