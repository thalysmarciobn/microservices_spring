package com.identityservice.domain.usecase

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.identityservice.application.enums.MailTypeEnum
import com.identityservice.application.enums.RecoveryTypeEnum
import com.identityservice.application.message.MailMessage
import com.identityservice.application.request.recovery.RecoveryRequest
import com.identityservice.application.response.recovery.RecoveryErrorResponse
import com.identityservice.application.response.recovery.RecoveryResponse
import com.identityservice.application.response.recovery.RecoverySentResponse
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class RecoveryUserUseCase(private val rabbitTemplate: RabbitTemplate) {

    fun execute(request: RecoveryRequest): RecoveryResponse {
        val type = request.type
        val value = request.value

        if (type == null || value == null)
            return RecoveryErrorResponse("Invalid Input")

        val objectMapper: ObjectMapper = jacksonObjectMapper()

        val message = when (type) {
            RecoveryTypeEnum.RECOVERY_BY_USERNAME -> this.rabbitTemplate.convertSendAndReceive(
                "mail",
                objectMapper.writeValueAsBytes(MailMessage(MailTypeEnum.RECOVERY_BY_USERNAME, value))
            )

            RecoveryTypeEnum.RECOVERY_BY_EMAIL -> this.rabbitTemplate.convertSendAndReceive(
                "mail",
                objectMapper.writeValueAsBytes(MailMessage(MailTypeEnum.RECOVERY_BY_EMAIL, value))
            )
        }

        return RecoverySentResponse(type)
    }
}
