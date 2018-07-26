package com.example.job

import com.example.job.config.JobConfig
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<JobConfig>(*args) {
        setBannerMode(Banner.Mode.OFF)
    }
}