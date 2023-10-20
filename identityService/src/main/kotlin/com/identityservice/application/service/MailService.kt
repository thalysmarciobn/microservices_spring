package com.identityservice.application.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.identityservice.application.enums.MailTypeEnum
import com.identityservice.application.enums.RecoveryTypeEnum
import com.identityservice.application.enums.RecoveryTypeEnum.*
import com.identityservice.application.message.MailMessage
import com.identityservice.application.response.recovery.RecoveryErrorResponse
import com.identityservice.application.response.recovery.RecoveryResponse
import com.identityservice.application.response.recovery.RecoverySentResponse
import com.identityservice.domain.repository.UserRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MailService(
    @Autowired private val rabbitTemplate: RabbitTemplate,
    @Autowired private val userRepository: UserRepository
) {
    fun execute(type: RecoveryTypeEnum, value: String): RecoveryResponse {
        val objectMapper: ObjectMapper = jacksonObjectMapper()

        val email: String = when (type) {
            RECOVERY_BY_USERNAME -> this.userRepository.findEmailByUsername(value)?.getEmail()
            RECOVERY_BY_EMAIL -> value
        } ?: return RecoveryErrorResponse("Email not found")

        val message = objectMapper.writeValueAsBytes(MailMessage(MailTypeEnum.RECOVERY, email))
        val response = this.rabbitTemplate.convertSendAndReceive("mail", message)

        return RecoverySentResponse(type, response.toString())
    }
}