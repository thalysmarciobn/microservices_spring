package com.identityservice.application.response.login

import com.identityservice.application.enums.LoginEnum

abstract class LoginResponse(
    val code: LoginEnum
)