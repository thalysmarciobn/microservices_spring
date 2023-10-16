package com.identityservice.presentation.controller

import com.identityservice.application.dto.UserDTO
import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.response.AuthenticationLoginErrorResponse
import com.identityservice.application.response.AuthenticationLoginSuccessResponse
import com.identityservice.application.response.AuthenticationResponse
import com.identityservice.application.service.AuthenticationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @PostMapping("/login")
    fun login(@RequestBody user: UserDTO): ResponseEntity<AuthenticationResponse> {
        val username = user.username
        val password = user.password

        if (username == null || password == null)
            return ResponseEntity.badRequest().body(AuthenticationLoginErrorResponse("Invalid Input", AuthenticationEnum.INVALID_INPUT))

        val authentication = this.authenticationService.authentication(username, password);

        return ResponseEntity.ok(AuthenticationLoginSuccessResponse(authentication))
    }
}
