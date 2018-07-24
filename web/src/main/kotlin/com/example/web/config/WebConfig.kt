package com.example.web.config

import com.example.base.config.BaseConfig
import com.example.biz.config.BizConfig
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@ComponentScan("com.example.web")
@Import(BaseConfig::class, BizConfig::class)
@EnableSwagger2
class WebConfig