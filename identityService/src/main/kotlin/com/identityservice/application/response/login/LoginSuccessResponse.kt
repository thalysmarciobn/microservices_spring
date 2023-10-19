package com.identityservice.application.response.login

import com.identityservice.application.enums.LoginEnum


class LoginSuccessResponse(var token: String) : LoginResponse(LoginEnum.SUCCESS)