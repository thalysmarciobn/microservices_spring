package com.project.service.identity.application.response.login

import com.project.service.identity.application.enums.LoginEnum

abstract class LoginResponse(
    val code: LoginEnum
)