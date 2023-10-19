package com.identityservice.application.response.register

import com.identityservice.application.enums.RegistrationEnum

class RegistrationErrorResponse(var message: String, code: RegistrationEnum) : RegistrationResponse(code)