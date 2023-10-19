package com.identityservice.application.response.login

import com.identityservice.application.enums.AuthenticationEnum

class LoginErrorResponse(var message: String, code: AuthenticationEnum) : LoginResponse(code)