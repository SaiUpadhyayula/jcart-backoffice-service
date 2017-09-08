package com.leantechstacks.jcart.bo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class BackofficeServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(BackofficeServiceApplication::class.java, *args)
}

@RestController
class IndexController
{
    @GetMapping("/")
    fun index() = "backoffice-service-api"

}
