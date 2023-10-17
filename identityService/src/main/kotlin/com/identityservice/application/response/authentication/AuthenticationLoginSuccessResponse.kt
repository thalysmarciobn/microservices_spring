package com.identityservice.application.response.authentication

import com.identityservice.application.dto.AuthenticationDTO
import com.identityservice.application.enums.AuthenticationEnum


class AuthenticationLoginSuccessResponse(var token: String) : AuthenticationResponse(AuthenticationEnum.SUCCESS)