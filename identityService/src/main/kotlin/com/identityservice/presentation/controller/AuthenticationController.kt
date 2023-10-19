package com.identityservice.presentation.controller

import com.identityservice.application.request.authentication.LoginRequest
import com.identityservice.application.request.registration.RegistrationRequest
import com.identityservice.application.response.login.LoginResponse
import com.identityservice.application.response.registration.RegistrationResponse
import com.identityservice.domain.usecase.LoginUserUseCase
import com.identityservice.domain.usecase.RegistrationUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/identity/auth"])
class AuthenticationController(private val loginUserUseCase: LoginUserUseCase,
                               private val registrationUserUseCase: RegistrationUserUseCase
) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok(this.loginUserUseCase.execute(request))
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegistrationRequest): ResponseEntity<RegistrationResponse> {
        return ResponseEntity.ok(this.registrationUserUseCase.execute(request))
    }
}

