package com.example.biz.util

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Configuration

@Configuration
class ContextUtil : ApplicationContextAware {

    companion object {
        private lateinit var context: ApplicationContext

        fun getContext(): ApplicationContext {
            return context
        }

        fun getBean(name: String): Any {
            return context.getBean(name)
        }

        fun <T> getBean(clazz: Class<T>): T {
            return context.getBean(clazz)
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

}