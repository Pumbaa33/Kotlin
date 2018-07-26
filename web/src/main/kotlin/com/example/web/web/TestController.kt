package com.example.web.web

import org.apache.commons.lang3.RandomStringUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class TestController {

    private val logger: Logger = LoggerFactory.getLogger(TestController::class.java)

    @GetMapping("/test")
    fun test(): String {
        val random = RandomStringUtils.randomAlphanumeric(4)
        logger.info(random)
        return random
    }
}