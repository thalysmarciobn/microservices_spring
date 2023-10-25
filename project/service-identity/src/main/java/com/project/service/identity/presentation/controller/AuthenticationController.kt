package com.project.service.identity.presentation.controller

import com.project.service.identity.application.request.login.LoginRequest
import com.project.service.identity.application.request.recovery.RecoveryRequest
import com.project.service.identity.application.request.registration.RegistrationRequest
import com.project.service.identity.application.response.login.LoginResponse
import com.project.service.identity.application.response.recovery.RecoveryResponse
import com.project.service.identity.application.response.registration.RegistrationResponse
import com.project.service.identity.domain.usecase.LoginUserUseCase
import com.project.service.identity.domain.usecase.RecoveryUserUseCase
import com.project.service.identity.domain.usecase.RegistrationUserUseCase
import io.micrometer.tracing.annotation.NewSpan
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/identity/auth"])
class AuthenticationController(private val loginUserUseCase: LoginUserUseCase,
                               private val registrationUserUseCase: RegistrationUserUseCase,
                               private val recoveryUserUseCase: RecoveryUserUseCase
) {

    @PostMapping("/login")
    @NewSpan("login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity.ok(this.loginUserUseCase.execute(request))
    }

    @PostMapping("/registration")
    @NewSpan("registration")
    fun register(@RequestBody request: RegistrationRequest): ResponseEntity<RegistrationResponse> {
        return ResponseEntity.ok(this.registrationUserUseCase.execute(request))
    }

    @PostMapping("/recovery")
    @NewSpan("recovery")
    fun recovery(@RequestBody request: RecoveryRequest): ResponseEntity<RecoveryResponse> {
        return ResponseEntity.ok(this.recoveryUserUseCase.execute(request))
    }

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }
}