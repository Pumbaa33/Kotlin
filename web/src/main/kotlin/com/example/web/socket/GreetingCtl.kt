package com.example.web.socket

import com.example.web.domain.Greeting
import com.example.web.domain.Message
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils

@Controller
class GreetingCtl {

    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    fun greeting(message: Message): Greeting {
        return Greeting("Hello ${HtmlUtils.htmlEscape(message.name)}")
    }
}