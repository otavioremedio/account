tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}

dependencies {
    "testFixturesImplementation"(project(":app"))
}