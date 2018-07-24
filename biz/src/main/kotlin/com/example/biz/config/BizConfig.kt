package com.example.biz.config

import com.example.base.config.BaseConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@ComponentScan("com.example.biz")
@Import(BaseConfig::class)
class BizConfig