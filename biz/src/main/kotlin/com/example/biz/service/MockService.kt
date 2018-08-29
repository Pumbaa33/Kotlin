package com.example.biz.service

import com.example.biz.domain.Person
import io.github.benas.randombeans.api.EnhancedRandom
import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service("MockService")
class MockService {

    @Autowired
    private lateinit var enhancedRandom: EnhancedRandom

    @Cacheable
    fun mockPerson(): Person {

        val person = enhancedRandom.nextObject(Person::class.java)

        return person
    }
}