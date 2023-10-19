package com.identityservice.domain.usecase

import com.identityservice.application.enums.RegistrationEnum
import com.identityservice.application.request.register.RegistrationRequest
import com.identityservice.application.response.register.RegistrationErrorResponse
import com.identityservice.application.response.register.RegistrationResponse
import com.identityservice.application.response.register.RegistrationSuccessResponse
import com.identityservice.application.service.RegisterService
import org.springframework.stereotype.Component

@Component
class RegistrationUserUseCase(private val registrationService: RegisterService) {

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