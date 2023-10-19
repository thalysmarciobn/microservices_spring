package com.identityservice.domain.usecase

import com.identityservice.application.request.recovery.RecoveryRequest
import com.identityservice.application.response.recovery.RecoveryResponse
import com.identityservice.application.response.recovery.RecoverySuccessResponse
import org.springframework.stereotype.Component

@Component
class RecoveryUserUseCase {

    fun execute(request: RecoveryRequest): RecoveryResponse {
        val type = request.type
        val value = request.value

        return RecoverySuccessResponse()
    }
}