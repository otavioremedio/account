dependencies {
    implementation(project(":commons"))
    implementation(project(":account"))
    "testImplementation"(testFixtures(project(":account")))
}

tasks.bootJar {
    enabled = false
}

tasks.jar {
    enabled = true
}
