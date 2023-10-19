package com.identityservice.application.request.register

data class RegistrationRequest(
    val username: String,
    val email: String,
    val password: String,
    val password2: String,
)