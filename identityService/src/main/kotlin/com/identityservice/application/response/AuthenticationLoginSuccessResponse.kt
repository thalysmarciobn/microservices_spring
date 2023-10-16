package com.identityservice.application.response

import com.fasterxml.jackson.annotation.JsonInclude
import com.identityservice.application.dto.AuthenticationDTO


class AuthenticationLoginSuccessResponse(private var data: AuthenticationDTO) : AuthenticationResponse(data.code)
{
    val token: String = data.token!!
}