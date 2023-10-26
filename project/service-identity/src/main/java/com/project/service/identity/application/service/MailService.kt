package com.project.service.identity.application.service

import com.project.service.identity.application.enums.RecoveryTypeEnum
import com.project.service.identity.application.response.recovery.RecoveryErrorResponse
import com.project.service.identity.application.response.recovery.RecoveryResponse
import com.project.service.identity.application.response.recovery.RecoverySentResponse
import com.project.service.identity.domain.repository.UserRepository
import com.project.shared.message.RoutingKeys
import com.project.shared.message.enums.MailTypeEnum
import com.project.shared.message.model.MailMessage
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MailService(
    @Autowired private val rabbitTemplate: RabbitTemplate,
    @Autowired private val userRepository: UserRepository
) {
    fun execute(type: RecoveryTypeEnum, value: String): RecoveryResponse {
        val email: String = when (type) {
            RecoveryTypeEnum.RECOVERY_BY_USERNAME -> this.userRepository.findEmailByUsername(value)?.getEmail()
            RecoveryTypeEnum.RECOVERY_BY_EMAIL -> value
        } ?: return RecoveryErrorResponse("Email not found")

        val response = this.rabbitTemplate.convertSendAndReceive(RoutingKeys.mailMessage, MailMessage(MailTypeEnum.RECOVERY, email))

        return RecoverySentResponse(type, response as String)
    }
}