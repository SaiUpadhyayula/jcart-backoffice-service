package com.leantechstacks.jcart.bo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BackofficeServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(BackofficeServiceApplication::class.java, *args)
}
