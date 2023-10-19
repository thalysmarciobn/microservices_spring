package com.identityservice.domain.usecase

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.identityservice.application.message.RecoveryMessage
import com.identityservice.application.request.recovery.RecoveryRequest
import com.identityservice.application.response.recovery.RecoveryErrorResponse
import com.identityservice.application.response.recovery.RecoveryResponse
import com.identityservice.application.response.recovery.RecoverySuccessResponse
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

        this.rabbitTemplate.convertSendAndReceive("mail", objectMapper.writeValueAsBytes(RecoveryMessage(type, value)))

        return RecoverySuccessResponse()
    }
}
