package com.identityservice.application.response.login

import com.identityservice.application.enums.AuthenticationEnum


class LoginSuccessResponse(var token: String) : LoginResponse(AuthenticationEnum.SUCCESS)