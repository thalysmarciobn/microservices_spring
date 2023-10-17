package com.identityservice.application.request.registration

data class RegistrationRequest(
    val username: String,
    val email: String,
    val password: String,
    val password2: String,
)