package com.example.web.socket

import com.example.web.domain.Greeting
import com.example.web.domain.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils
import java.util.*

@Controller
class GreetingCtl {

    @Autowired
    private lateinit var simpMessagingTemplate : SimpMessagingTemplate

    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    fun greeting(message: Message): Greeting {
        return Greeting("Hello ${HtmlUtils.htmlEscape(message.name)}")
    }

    @Scheduled(fixedRate = 3000L)
    fun sendToClient() {
        val list: List<String> = arrayListOf("Jonathan", "Joseph", "Jotaro", "Josuke", "Jolyne")
        println("Send Message start!")
        this.simpMessagingTemplate.convertAndSend("/topic/greetings", Greeting("Hello ${list[Random().nextInt(list.size)]}"))
    }
}