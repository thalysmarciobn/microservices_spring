package com.identityservice.application.dto

import com.identityservice.application.enums.AuthenticationEnum

class AuthenticationSuccessDTO(var token: String) : AuthenticationDTO(AuthenticationEnum.SUCCESS)
