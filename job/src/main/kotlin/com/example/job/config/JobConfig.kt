package com.example.job.config

import com.example.base.config.BaseConfig
import com.example.biz.config.BizConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@ComponentScan("com.example.job")
@Import(BaseConfig::class, BizConfig::class)
@EnableScheduling
class JobConfig