package com.example.base.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@ComponentScan("com.example.base")
@EnableAspectJAutoProxy(proxyTargetClass = true)
class BaseConfig