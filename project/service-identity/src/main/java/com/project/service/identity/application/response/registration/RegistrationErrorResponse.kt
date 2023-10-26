package com.project.service.identity.application.response.registration

import com.project.service.identity.application.enums.RegistrationEnum

class RegistrationErrorResponse(var message: String, code: RegistrationEnum) : RegistrationResponse(code)