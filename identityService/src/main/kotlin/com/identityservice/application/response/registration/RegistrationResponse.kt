package com.identityservice.application.response.registration

import com.identityservice.application.enums.RegistrationEnum

abstract class RegistrationResponse(
    val code: RegistrationEnum
)