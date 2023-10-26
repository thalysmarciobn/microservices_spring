package com.project.service.identity.application.service

import com.project.service.identity.configuration.JwtConfig
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*

@Component
class CryptographyService(
    @Autowired private val jwtConfig: JwtConfig
) {
    fun hmacShaKeyFor(secret: ByteArray): Key {
        return Keys.hmacShaKeyFor(secret)
    }

    fun generateToken(username: String, password: String): String {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + this.jwtConfig.expiration() * 1000))
            .signWith(this.hmacShaKeyFor(this.jwtConfig.secretKey()), SignatureAlgorithm.HS512)
            .compact()
    }
}