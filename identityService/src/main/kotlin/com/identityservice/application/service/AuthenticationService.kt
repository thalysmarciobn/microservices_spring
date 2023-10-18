package com.identityservice.application.service

import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.configuration.JwtConfig
import com.identityservice.domain.repository.UserRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationService(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val jwtConfig: JwtConfig
) {
    fun verify(username: String, password: String): AuthenticationEnum {
        val user = this.userRepository.findByUsername(username).orElse(null) ?: return AuthenticationEnum.NOT_FOUND

        if (user.password != password)
            return AuthenticationEnum.INCORRECT_PASSWORD

        return AuthenticationEnum.SUCCESS
    }
}