package com.identityservice.application.response.register

import com.identityservice.application.enums.RegistrationEnum

abstract class RegistrationResponse(
    val code: RegistrationEnum
)