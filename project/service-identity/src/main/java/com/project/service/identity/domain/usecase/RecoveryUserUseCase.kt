package com.project.service.identity.domain.usecase

import com.project.service.identity.application.request.recovery.RecoveryRequest
import com.project.service.identity.application.response.recovery.RecoveryErrorResponse
import com.project.service.identity.application.response.recovery.RecoveryResponse
import com.project.service.identity.application.service.MailService
import org.springframework.stereotype.Component

@Component
class RecoveryUserUseCase(private val mailService: MailService) {

    fun execute(request: RecoveryRequest): RecoveryResponse {
        val type = request.type
        val value = request.value

        if (type == null || value == null)
            return RecoveryErrorResponse("Invalid Input")

        return this.mailService.execute(request.type, request.value)
    }
}