package com.identityservice.presentation.controller

import com.identityservice.application.dto.UserDTO
import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.request.authentication.AuthenticationRequest
import com.identityservice.application.request.registration.RegistrationRequest
import com.identityservice.application.response.authentication.AuthenticationLoginErrorResponse
import com.identityservice.application.response.authentication.AuthenticationLoginSuccessResponse
import com.identityservice.application.response.authentication.AuthenticationResponse
import com.identityservice.application.response.registration.RegistrationResponse
import com.identityservice.application.service.AuthenticationService
import com.identityservice.application.service.RegistrationService
import com.identityservice.domain.usecase.CreateUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/api/v1/auth"])
class AuthenticationController(private val authenticationService: AuthenticationService,
    private val createUserUseCase: CreateUserUseCase
) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegistrationRequest): ResponseEntity<RegistrationResponse> {
        return ResponseEntity.ok(this.createUserUseCase.execute(request))
    }

    @PostMapping("/login")
    fun login(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        val username = request.username
        val password = request.password

        if (username == null || password == null)
            return ResponseEntity.badRequest()
                .body(AuthenticationLoginErrorResponse("Invalid Input", AuthenticationEnum.INVALID_INPUT))

        val authentication = this.authenticationService.authentication(username, password)

        return when (authentication.code) {
            AuthenticationEnum.SUCCESS -> ResponseEntity.ok(AuthenticationLoginSuccessResponse(authentication))
            AuthenticationEnum.NOT_FOUND -> ResponseEntity.ok(AuthenticationLoginErrorResponse("a", authentication))
            AuthenticationEnum.INCORRECT_PASSWORD -> ResponseEntity.ok(
                AuthenticationLoginErrorResponse(
                    "b",
                    authentication
                )
            )

            AuthenticationEnum.INVALID_INPUT -> ResponseEntity.ok(AuthenticationLoginErrorResponse("c", authentication))
        }
    }
}

