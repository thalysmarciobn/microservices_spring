package com.project.service.identity.domain.usecase

import com.project.service.identity.application.enums.LoginEnum
import com.project.service.identity.application.request.login.LoginRequest
import com.project.service.identity.application.response.login.LoginErrorResponse
import com.project.service.identity.application.response.login.LoginResponse
import com.project.service.identity.application.response.login.LoginSuccessResponse
import com.project.service.identity.application.service.CryptographyService
import com.project.service.identity.application.service.LoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class LoginUserUseCase(@Autowired private val loginService: LoginService,
                       @Autowired private val cryptographyService: CryptographyService
) {

    fun execute(request: LoginRequest): LoginResponse {
        val username = request.username
        val password = request.password

        if (username == null || password == null)
            return LoginErrorResponse(LoginEnum.INVALID_INPUT)

        return when (val authentication = this.loginService.verify(username, password)) {
            LoginEnum.SUCCESS -> {
                val token = this.cryptographyService.generateToken(username, password)
                return LoginSuccessResponse(token)
            }
            else -> LoginErrorResponse(authentication)
        }
    }
}