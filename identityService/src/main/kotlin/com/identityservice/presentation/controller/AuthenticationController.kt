package com.identityservice.presentation.controller

import com.identityservice.application.dto.UserDTO
import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.response.AuthenticationLoginErrorResponse
import com.identityservice.application.response.AuthenticationLoginSuccessResponse
import com.identityservice.application.response.AuthenticationResponse
import com.identityservice.application.service.AuthenticationService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @GetMapping("/test")
    fun test(): ResponseEntity<String> {
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/login")
    fun login(@RequestBody user: UserDTO): ResponseEntity<AuthenticationResponse> {
        val username = user.username
        val password = user.password

        if (username == null || password == null)
            return ResponseEntity.badRequest().body(AuthenticationLoginErrorResponse("Invalid Input", AuthenticationEnum.INVALID_INPUT))

        val authentication = this.authenticationService.authentication(username, password)

        return when (authentication.code) {
            AuthenticationEnum.SUCCESS -> ResponseEntity.ok(AuthenticationLoginSuccessResponse(authentication))
            AuthenticationEnum.NOT_FOUND -> ResponseEntity.ok(AuthenticationLoginErrorResponse("a", authentication))
            AuthenticationEnum.INCORRECT_PASSWORD -> ResponseEntity.ok(AuthenticationLoginErrorResponse("b", authentication))
            AuthenticationEnum.INVALID_INPUT -> ResponseEntity.ok(AuthenticationLoginErrorResponse("c", authentication))
        }
    }
}

