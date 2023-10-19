package com.identityservice.domain.usecase

import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.request.authentication.LoginRequest
import com.identityservice.application.response.login.LoginErrorResponse
import com.identityservice.application.response.login.LoginSuccessResponse
import com.identityservice.application.response.login.LoginResponse
import com.identityservice.application.service.AuthenticationService
import com.identityservice.application.service.CryptographyService
import org.springframework.stereotype.Component

@Component
class LoginUserUseCase(private val authenticationService: AuthenticationService,
                       private val cryptographyService: CryptographyService) {

    fun execute(request: LoginRequest): LoginResponse {
        val username = request.username
        val password = request.password

        if (username == null || password == null)
            return LoginErrorResponse("a", AuthenticationEnum.INVALID_INPUT)

        return when (val authentication = this.authenticationService.verify(username, password)) {
            AuthenticationEnum.SUCCESS -> {
                val token = this.cryptographyService.generateToken(username, password)
                return LoginSuccessResponse(token)
            }
            else -> LoginErrorResponse("a", authentication)
        }
    }
}