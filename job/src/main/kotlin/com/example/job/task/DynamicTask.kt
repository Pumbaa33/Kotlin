package com.example.job.task

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar
import org.springframework.stereotype.Component

@Component
class DynamicTask : SchedulingConfigurer {

    private val logger: Logger = LoggerFactory.getLogger(DynamicTask::class.java)

    private lateinit var registrar: ScheduledTaskRegistrar

    @Autowired
    private lateinit var beanProcessor: ScheduledAnnotationBeanPostProcessor

    override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {
        registrar = taskRegistrar
    }

    fun dynamic(time: String) {
        val scheduledTasks = beanProcessor.scheduledTasks
        //TODO
    }

}