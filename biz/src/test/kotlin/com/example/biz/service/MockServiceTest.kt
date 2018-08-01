package com.example.biz.service

import com.example.base.config.BaseConfig
import com.example.biz.config.BizConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [BaseConfig::class, BizConfig::class])
@ActiveProfiles("dev")
class MockServiceTest {

    @Autowired
    private lateinit var mockService: MockService

    @Test
    fun testBean() {
        val person = mockService.mockPerson()
        println(person)
    }
}