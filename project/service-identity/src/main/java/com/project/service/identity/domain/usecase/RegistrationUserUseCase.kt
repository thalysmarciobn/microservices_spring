package com.project.service.identity.domain.usecase

import com.project.service.identity.application.enums.RegistrationEnum
import com.project.service.identity.application.request.registration.RegistrationRequest
import com.project.service.identity.application.response.registration.RegistrationErrorResponse
import com.project.service.identity.application.response.registration.RegistrationResponse
import com.project.service.identity.application.response.registration.RegistrationSuccessResponse
import com.project.service.identity.application.service.RegistrationService
import org.springframework.stereotype.Component

@Component
class RegistrationUserUseCase(private val registrationService: RegistrationService) {

    fun execute(request: RegistrationRequest): RegistrationResponse {
        val username = request.username
        val password = request.password
        val password2 = request.password2

        if (this.registrationService.isInUseUsername(username))
            return RegistrationErrorResponse("message1", RegistrationEnum.EXIST)

        if (this.registrationService.isInUseEmail(username))
            return RegistrationErrorResponse("message2", RegistrationEnum.EXIST)

        if (password != password2)
            return RegistrationErrorResponse("message3", RegistrationEnum.INCORRECT_PASSWORD)

        val user = this.registrationService.register(request)

        if (user)
            return RegistrationSuccessResponse()

        return RegistrationErrorResponse("message4", RegistrationEnum.INVALID_INPUT)
    }
}