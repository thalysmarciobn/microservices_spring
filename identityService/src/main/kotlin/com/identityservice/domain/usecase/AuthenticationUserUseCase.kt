package com.identityservice.domain.usecase

import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.request.authentication.AuthenticationRequest
import com.identityservice.application.response.authentication.AuthenticationLoginErrorResponse
import com.identityservice.application.response.authentication.AuthenticationLoginSuccessResponse
import com.identityservice.application.response.authentication.AuthenticationResponse
import com.identityservice.application.service.AuthenticationService
import com.identityservice.application.service.CryptographyService
import org.springframework.stereotype.Component

@Component
class AuthenticationUserUseCase(private val authenticationService: AuthenticationService,
    private val cryptographyService: CryptographyService) {

    fun execute(request: AuthenticationRequest): AuthenticationResponse {
        val username = request.username
        val password = request.password

        if (username == null || password == null)
            return AuthenticationLoginErrorResponse("a", AuthenticationEnum.INVALID_INPUT)

        return when (val authentication = this.authenticationService.verify(username, password)) {
            AuthenticationEnum.SUCCESS -> {
                val token = this.cryptographyService.generateToken(username, password)
                return AuthenticationLoginSuccessResponse(token)
            }
            else -> AuthenticationLoginErrorResponse("a", authentication)
        }
    }
}