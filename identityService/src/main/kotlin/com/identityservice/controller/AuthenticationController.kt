package com.identityservice.controller

import com.identityservice.dto.UserDTO
import com.identityservice.service.AuthenticationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthenticationController(private val authenticationService: AuthenticationService) {

    @PostMapping("/login")
    fun login(@RequestBody user: UserDTO): ResponseEntity<String> {
        val username = user.password
        val password = user.password
        return ResponseEntity.status(401).build()
    }
}
