package com.identityservice.application.service

import com.identityservice.application.dto.AuthenticationDTO
import com.identityservice.application.dto.AuthenticationDefaultDTO
import com.identityservice.application.dto.AuthenticationSuccessDTO
import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    @Autowired private val userRepository: UserRepository
) {
    fun authentication(username: String, password: String): AuthenticationDTO {
        val user = this.userRepository.findByUsername(username).orElse(null) ?: return AuthenticationDefaultDTO(AuthenticationEnum.NOT_FOUND)
        val token = ""

        if (user.password != password)
            return AuthenticationDefaultDTO(AuthenticationEnum.INCORRECT_PASSWORD)

        return AuthenticationSuccessDTO(token)
    }
}