package com.service.service1.receivers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.service.service1.application.message.MailMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageReceiver {

    @RabbitListener(queues = ["mail"])
    fun handleMessage(message: ByteArray) {
        val objectMapper: ObjectMapper = jacksonObjectMapper()

        val recoveryMessage: MailMessage = objectMapper.readValue(message, MailMessage::class.java)

        println(recoveryMessage.type)
    }
}