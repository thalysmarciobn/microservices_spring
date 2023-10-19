package com.identityservice.application.response.register

import com.identityservice.application.enums.RegisterEnum

class RegistrationErrorResponse(var message: String, code: RegisterEnum) : RegistrationResponse(code)