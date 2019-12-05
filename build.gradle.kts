version = "1.0.0"
description = "A sample parser using JFlex and Cup."

repositories {
    jcenter()
}

plugins {
    java
    id("cup.gradle.cup-gradle-plugin") version "1.2"
    id("org.xbib.gradle.plugin.jflex") version "1.2.1"
}

tasks.cupCompile {
    dependsOn(tasks.jflex)
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "example.Main"
        )
    }
    from(configurations.runtimeClasspath.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}
