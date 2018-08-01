package com.example.web.socket

import com.example.web.domain.Greeting
import com.example.web.domain.Message
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import java.util.concurrent.atomic.AtomicInteger
import javax.servlet.http.HttpServletRequest

@Controller
class BroadcastCtl {

    companion object {

        private val logger: Logger = LoggerFactory.getLogger(BroadcastCtl::class.java)
    }

    private var count: AtomicInteger = AtomicInteger(0)

    @MessageMapping("/receive")
    @SendTo("/topic/response")
    fun broadcast(message: Message): Greeting {
        logger.info("receive message ${message.name}")
        return Greeting("BroadcastCtl receive [${count.incrementAndGet()}] records")
    }

    @RequestMapping("/broadcast/index")
    fun broadcastIndex(req: HttpServletRequest): String {
        logger.info("host: ${req.remoteHost}")
        return "websocket/ws-broadcast"
    }

}