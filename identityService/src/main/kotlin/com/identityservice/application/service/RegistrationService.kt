package com.identityservice.application.service

import com.identityservice.application.request.registration.RegistrationRequest
import com.identityservice.domain.model.User
import com.identityservice.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class RegistrationService(val userRepository: UserRepository, val encoder: PasswordEncoder) {

    fun register(request: RegistrationRequest): User {
        return this.userRepository.save(User(request.username, this.encoder.encode(request.password), request.email))
    }

    fun isInUseUsername(username: String): Boolean {
        return this.userRepository.findByUsername(username) != null
    }

    fun isInUseEmail(email: String): Boolean {
        return this.userRepository.findByEmail(email) != null
    }
}