package com.project.service.identity.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JwtConfig {

    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration}")
    private val expiration: Long = 3600

    @Bean
    fun secretKey(): ByteArray {
        return this.secret.toByteArray()
    }

    @Bean
    fun expiration(): Long {
        return this.expiration
    }
}