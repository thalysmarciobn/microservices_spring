package com.identityservice.application.response.authentication

import com.identityservice.application.dto.AuthenticationDTO
import com.identityservice.application.enums.AuthenticationEnum

class AuthenticationLoginErrorResponse(var message: String, code: AuthenticationEnum) : AuthenticationResponse(code) {
    constructor(message: String, data: AuthenticationDTO) : this(message, data.code)
}