package com.project.service.identity.application.service

import com.project.service.identity.application.request.registration.RegistrationRequest
import com.project.service.identity.domain.model.User
import com.project.service.identity.domain.repository.UserRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class RegistrationService(val userRepository: UserRepository) {

    fun register(request: RegistrationRequest): Boolean {
        val user: User? = this.userRepository.findByUsername(request.username).getOrNull()
        if (user != null)
            return false
        this.userRepository.saveAndFlush(User(request.username, request.password, request.email))
        return true
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