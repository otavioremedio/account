package org.pismo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["org.pismo"])
class PismoApp

fun main(args: Array<String>) {
    runApplication<PismoApp>(*args)
}
