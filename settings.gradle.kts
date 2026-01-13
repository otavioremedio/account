plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "pismo-account"
include("app")
include("account")
include("transaction")
include("commons")
