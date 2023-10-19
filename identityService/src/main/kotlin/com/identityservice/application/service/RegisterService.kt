package com.identityservice.application.service

import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.request.register.RegistrationRequest
import com.identityservice.domain.model.User
import com.identityservice.domain.repository.UserRepository
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class RegisterService(val userRepository: UserRepository) {

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