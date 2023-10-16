package com.identityservice.application.dto

import com.identityservice.application.enums.AuthenticationEnum

class AuthenticationDefaultDTO(override var code: AuthenticationEnum) : AuthenticationDTO(code)
