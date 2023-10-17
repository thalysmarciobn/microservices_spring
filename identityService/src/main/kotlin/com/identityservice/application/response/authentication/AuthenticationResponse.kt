package com.identityservice.application.response.authentication

import com.identityservice.application.enums.AuthenticationEnum

abstract class AuthenticationResponse(
    val code: AuthenticationEnum
)