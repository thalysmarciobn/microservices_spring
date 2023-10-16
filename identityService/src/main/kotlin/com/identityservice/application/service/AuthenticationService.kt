package com.identityservice.application.service

import com.identityservice.application.dto.AuthenticationDTO
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
    fun authentication(username: String, password: String): AuthenticationDTO {
        val user = this.userRepository.findByUsername(username).orElse(null) ?: return AuthenticationDTO(
            AuthenticationEnum.NOT_FOUND
        )

        if (user.password != password)
            return AuthenticationDTO(AuthenticationEnum.INCORRECT_PASSWORD)

        val token = Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtConfig.expiration() * 1000))
            .signWith(SignatureAlgorithm.HS512, this.jwtConfig.secretKey())
            .compact()

        return AuthenticationDTO(AuthenticationEnum.SUCCESS, token)
    }
}