package com.identityservice.application.dto

import com.identityservice.application.enums.AuthenticationEnum

abstract class AuthenticationDTO(open var code: AuthenticationEnum)
