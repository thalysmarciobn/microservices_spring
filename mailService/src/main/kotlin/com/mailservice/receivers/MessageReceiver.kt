package com.mailservice.receivers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.mailservice.application.enums.MailTypeEnum
import com.mailservice.application.message.MailMessage
import com.mailservice.application.service.MailService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.springframework.web.servlet.View

@Component
class MessageReceiver(
    private val mailService: MailService,
) {

    @RabbitListener(queues = ["mail"])
    fun handleMessage(message: ByteArray): String {
        val objectMapper: ObjectMapper = jacksonObjectMapper()

        val mailMessage: MailMessage = objectMapper.readValue(message, MailMessage::class.java)
        println(mailMessage.type)
        println(mailMessage.value)
        try {
            when (mailMessage.type) {
                MailTypeEnum.RECOVERY -> this.mailService.send(mailMessage.value, "aa", "aaaa")
                MailTypeEnum.SEND_EMAIL -> println("SEND_EMAIL")
            }
        } catch (error: Exception) {

        }
        return "test"
    }
}