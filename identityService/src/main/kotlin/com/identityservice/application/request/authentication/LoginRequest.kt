package com.identityservice.application.request.authentication

data class LoginRequest(
    val username: String?,
    val password: String?
)