package com.example.biz.service

import com.example.biz.domain.Person
import io.github.benas.randombeans.api.EnhancedRandom
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("MockService")
class MockService {

    @Autowired
    private lateinit var enhancedRandom: EnhancedRandom

    fun mockPerson(): Person {

        val person = enhancedRandom.nextObject(Person::class.java)

        return person
    }
}