package com.identityservice.application.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.identityservice.application.enums.LoginEnum

@JsonInclude(JsonInclude.Include.NON_NULL)
class AuthenticationDTO(var code: LoginEnum, var token: String?) {
    constructor(code: LoginEnum) : this(code, null)
}
