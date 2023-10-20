package com.identityservice.application.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.identityservice.application.enums.MailTypeEnum
import com.identityservice.application.enums.RecoveryTypeEnum
import com.identityservice.application.enums.RecoveryTypeEnum.*
import com.identityservice.application.message.MailMessage
import com.identityservice.infrastructure.repository.UserRepositoryImpl
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MailService(
    @Autowired private val rabbitTemplate: RabbitTemplate,
    @Autowired private val userRepositoryImpl: UserRepositoryImpl
) {
    fun execute(type: RecoveryTypeEnum, value: String): String {
        val objectMapper: ObjectMapper = jacksonObjectMapper()

        val message = when (type) {
            RECOVERY_BY_USERNAME -> this.rabbitTemplate.convertSendAndReceive(
                "mail",
                objectMapper.writeValueAsBytes(MailMessage(MailTypeEnum.RECOVERY, userRepositoryImpl.findEmailByUsername(value).get()))
            )

            RECOVERY_BY_EMAIL -> this.rabbitTemplate.convertSendAndReceive(
                "mail",
                objectMapper.writeValueAsBytes(MailMessage(MailTypeEnum.RECOVERY, value))
            )
        }
        return message as String
    }
}