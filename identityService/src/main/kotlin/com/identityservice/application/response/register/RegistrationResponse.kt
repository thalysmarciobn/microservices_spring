package com.identityservice.application.response.register

import com.identityservice.application.enums.RegisterEnum

abstract class RegistrationResponse(
    val code: RegisterEnum
)