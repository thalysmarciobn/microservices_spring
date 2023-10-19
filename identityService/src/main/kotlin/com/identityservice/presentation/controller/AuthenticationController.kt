package com.identityservice.presentation.controller

import com.identityservice.application.request.login.LoginRequest
import com.identityservice.application.request.recovery.RecoveryRequest
import com.identityservice.application.request.register.RegistrationRequest
import com.identityservice.application.response.login.LoginResponse
import com.identityservice.application.response.recovery.RecoveryResponse
import com.identityservice.application.response.register.RegistrationResponse
import com.identityservice.domain.usecase.LoginUserUseCase
import com.identityservice.domain.usecase.RecoveryUserUseCase
import com.identityservice.domain.usecase.RegistrationUserUseCase
import io.micrometer.tracing.annotation.NewSpan
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/identity/auth"])
class AuthenticationController(private val loginUserUseCase: LoginUserUseCase,
                               private val registrationUserUseCase: RegistrationUserUseCase,
                               private val recoveryUserUseCase: RecoveryUserUseCase
) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }

    @PostMapping("/login")
    @NewSpan("login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok(this.loginUserUseCase.execute(request))
    }

    @PostMapping("/register")
    @NewSpan("register")
    fun register(@RequestBody request: RegistrationRequest): ResponseEntity<RegistrationResponse> {
        return ResponseEntity.ok(this.registrationUserUseCase.execute(request))
    }

    @PostMapping("/recovery")
    @NewSpan("recovery")
    fun recovery(@RequestBody request: RecoveryRequest): ResponseEntity<RecoveryResponse> {
        return ResponseEntity.ok(this.recoveryUserUseCase.execute(request))
    }
}

