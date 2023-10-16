package com.identityservice.application.service

import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    @Autowired private val userRepository: UserRepository
) {
    fun authentication(username: String, password: String): AuthenticationEnum {
        val user = this.userRepository.findByUsername(username).orElse(null) ?: return AuthenticationEnum.NOT_FOUND

        if (user.password != password)
            return AuthenticationEnum.INCORRECT_PASSWORD

        return AuthenticationEnum.SUCCESS
    }
}