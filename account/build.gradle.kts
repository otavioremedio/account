dependencies {
    implementation(project(":commons"))
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

