package com.identityservice.application.response

import com.identityservice.application.dto.AuthenticationDTO
import com.identityservice.application.dto.AuthenticationSuccessDTO
import com.identityservice.application.enums.AuthenticationEnum

class AuthenticationLoginSuccessResponse(private var data: AuthenticationDTO) : AuthenticationResponse(data.code)
