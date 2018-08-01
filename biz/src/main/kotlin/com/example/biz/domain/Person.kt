package com.example.biz.domain

import com.example.biz.random.IDCardRandom
import io.github.benas.randombeans.annotation.Randomizer
import java.util.*

class Person {

    var name: String? = null
    var gender: String? = null
    var birthday: Date? = null
    @Randomizer(IDCardRandom::class)
    var idCard: String? = null

    override fun toString(): String {
        return "Person(name=$name, gender=$gender, birthday=$birthday, idCard=$idCard)"
    }
}