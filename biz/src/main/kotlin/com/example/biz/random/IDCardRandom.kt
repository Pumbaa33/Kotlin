package com.example.biz.random

import com.example.biz.service.MockService
import com.example.biz.util.ContextUtil
import io.github.benas.randombeans.api.Randomizer

class IDCardRandom : Randomizer<String> {


    override fun getRandomValue(): String {
        val bean = ContextUtil.getBean(MockService::class.java)
        return "aaa$bean"

    }

}