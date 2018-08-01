package com.example.web.domain

class Message {

    lateinit var name: String

    constructor()

    constructor(name: String) : this() {
        this.name = name
    }
}