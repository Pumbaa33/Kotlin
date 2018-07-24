package com.example.web.web

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kotlin")
class TestController {

    @GetMapping("/test")
    fun test() {
        RandomStringUtils.random(16)
    }
}