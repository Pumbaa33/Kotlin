package com.example.web

import com.example.web.config.WebConfig
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<WebConfig>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}