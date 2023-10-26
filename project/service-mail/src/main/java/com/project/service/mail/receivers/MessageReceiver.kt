package com.project.service.mail.receivers

import com.project.service.mail.application.service.MailService
import com.project.shared.message.RoutingKeys
import com.project.shared.message.enums.MailTypeEnum
import com.project.shared.message.model.MailMessage
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class MessageReceiver(
    private val mailService: MailService,
) {

    @RabbitListener(queues = [RoutingKeys.mailMessage])
    fun handleMessage(@Payload message: MailMessage): String {
        println(message.type)
        println(message.value)
        try {
            when (message.type) {
                MailTypeEnum.RECOVERY -> this.mailService.send(message.value, "aa", "aaaa")
            }
        } catch (_: Exception) {

        }
        return "test"
    }
}