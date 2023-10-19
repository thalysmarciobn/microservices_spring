package com.identityservice.application.response.login

import com.identityservice.application.enums.LoginEnum

class LoginErrorResponse(var message: String, code: LoginEnum) : LoginResponse(code)