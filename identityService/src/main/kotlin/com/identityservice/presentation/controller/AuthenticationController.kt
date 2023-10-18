package com.identityservice.presentation.controller

import com.identityservice.application.request.authentication.AuthenticationRequest
import com.identityservice.application.request.registration.RegistrationRequest
import com.identityservice.application.response.authentication.AuthenticationResponse
import com.identityservice.application.response.registration.RegistrationResponse
import com.identityservice.domain.usecase.AuthenticationUserUseCase
import com.identityservice.domain.usecase.RegistrationUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/auth"])
class AuthenticationController(private val authenticationUserUseCase: AuthenticationUserUseCase,
    private val registrationUserUseCase: RegistrationUserUseCase
) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }

    @PostMapping("/authentication")
    fun login(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        return ResponseEntity.ok(this.authenticationUserUseCase.execute(request))
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegistrationRequest): ResponseEntity<RegistrationResponse> {
        return ResponseEntity.ok(this.registrationUserUseCase.execute(request))
    }
}

