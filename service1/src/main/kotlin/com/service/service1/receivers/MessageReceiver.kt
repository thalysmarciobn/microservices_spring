package com.service.service1.receivers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.service.service1.application.message.RecoveryMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class MessageReceiver {

    @RabbitListener(queues = ["mail"])
    fun handleMessage(message: ByteArray) {
        val objectMapper: ObjectMapper = jacksonObjectMapper()

        val recoveryMessage: RecoveryMessage = objectMapper.readValue(message, RecoveryMessage::class.java)

        println(recoveryMessage.type)
    }
}