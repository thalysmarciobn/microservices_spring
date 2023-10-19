package com.identityservice.application.response.login

import com.identityservice.application.enums.AuthenticationEnum

abstract class LoginResponse(
    val code: AuthenticationEnum
)