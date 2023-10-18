package com.identityservice.application.service

import com.identityservice.application.request.registration.RegistrationRequest
import com.identityservice.domain.model.User
import com.identityservice.domain.repository.UserRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class RegistrationService(val userRepository: UserRepository) {

    fun register(request: RegistrationRequest): User? {
        return this.userRepository.saveAndFlush(User(request.username, request.password, request.email))
    }

    fun isInUseUsername(username: String): Boolean {
        val user: User? = this.userRepository.findByEmail(username).getOrNull()
        return user != null
    }

    fun isInUseEmail(email: String): Boolean {
        val user: User? =  this.userRepository.findByEmail(email).getOrNull()
        return user != null
    }
}