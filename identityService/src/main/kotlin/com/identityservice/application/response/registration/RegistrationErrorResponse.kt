package com.identityservice.application.response.registration

import com.identityservice.application.enums.RegistrationEnum

class RegistrationErrorResponse(var message: String, code: RegistrationEnum) : RegistrationResponse(code)