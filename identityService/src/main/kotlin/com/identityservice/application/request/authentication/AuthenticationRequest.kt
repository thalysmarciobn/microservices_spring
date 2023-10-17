package com.identityservice.application.request.authentication

data class AuthenticationRequest(
    val username: String?,
    val password: String?
)