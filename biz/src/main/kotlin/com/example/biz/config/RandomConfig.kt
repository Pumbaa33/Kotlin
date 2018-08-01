package com.example.biz.config

import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RandomConfig {

    @Bean
    fun enhancedRandom(): EnhancedRandom {
        return EnhancedRandomBuilder.aNewEnhancedRandomBuilder().build()
    }
}