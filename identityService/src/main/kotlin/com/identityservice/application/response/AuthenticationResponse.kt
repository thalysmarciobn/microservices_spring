package com.identityservice.application.response

import com.identityservice.application.enums.AuthenticationEnum

abstract class AuthenticationResponse(
    val code: AuthenticationEnum
)