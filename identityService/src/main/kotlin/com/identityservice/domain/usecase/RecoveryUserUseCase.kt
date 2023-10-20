package com.identityservice.domain.usecase

import com.identityservice.application.request.recovery.RecoveryRequest
import com.identityservice.application.response.recovery.RecoveryErrorResponse
import com.identityservice.application.response.recovery.RecoveryResponse
import com.identityservice.application.response.recovery.RecoverySentResponse
import com.identityservice.application.service.MailService
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
