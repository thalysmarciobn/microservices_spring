package com.project.service.identity.application.service

import com.project.service.identity.application.enums.LoginEnum
import com.project.service.identity.configuration.JwtConfig
import com.project.service.identity.domain.repository.UserRepository
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