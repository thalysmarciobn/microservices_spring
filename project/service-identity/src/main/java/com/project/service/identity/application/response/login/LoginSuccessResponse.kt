package com.project.service.identity.application.response.login

import com.project.service.identity.application.enums.LoginEnum

class LoginSuccessResponse(var token: String) : LoginResponse(LoginEnum.SUCCESS)