package com.identityservice.configuration

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.security.Key

@Configuration
class JwtConfig {

    @Value("\${jwt.secret}")
    private val secret: String? = null

    @Value("\${jwt.expiration}")
    private val expiration: Long = 3600

    @Bean
    fun secretKey(): Key {
        return Keys.hmacShaKeyFor(this.secret!!.toByteArray())
    }

    @Bean
    fun expiration(): Long {
        return this.expiration
    }
}