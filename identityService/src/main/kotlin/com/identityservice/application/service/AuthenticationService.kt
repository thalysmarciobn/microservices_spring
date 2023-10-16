package com.identityservice.application.service

import com.identityservice.application.dto.AuthenticationDTO
import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    @Autowired private val userRepository: UserRepository
) {
    fun authentication(username: String, password: String): AuthenticationDTO {
        val user = this.userRepository.findByUsername(username).orElse(null) ?: return AuthenticationDTO(
            AuthenticationEnum.NOT_FOUND
        )

        if (user.password != password)
            return AuthenticationDTO(AuthenticationEnum.INCORRECT_PASSWORD)

        val token = "test"
        return AuthenticationDTO(AuthenticationEnum.SUCCESS, token)
    }
}