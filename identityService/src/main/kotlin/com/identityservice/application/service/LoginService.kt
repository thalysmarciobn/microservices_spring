package com.identityservice.application.service

import com.identityservice.application.enums.LoginEnum
import com.identityservice.configuration.JwtConfig
import com.identityservice.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LoginService(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val jwtConfig: JwtConfig
) {
    fun verify(username: String, password: String): LoginEnum {
        val user = this.userRepository.findByUsername(username).orElse(null) ?: return LoginEnum.NOT_FOUND

        if (user.password != password)
            return LoginEnum.INCORRECT_PASSWORD

        return LoginEnum.SUCCESS
    }
}