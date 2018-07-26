package com.example.job.task

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class TestTask {

    private val logger: Logger = LoggerFactory.getLogger(TestTask::class.java)

    @Scheduled(cron = "0/3 * * * * ?")
    fun testCron() {
        logger.info("Test cron task is running !!!")
    }

    @Scheduled(fixedDelay = 3 * 1000L)
    fun testDelay() {
        logger.info("Test delay task is running !!!")
    }

    @Scheduled(fixedRate = 3 * 1000L)
    fun testRate() {
        logger.info("Test rate task is running !!!")
    }
}