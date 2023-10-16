package com.identityservice.application.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.identityservice.application.enums.AuthenticationEnum

@JsonInclude(JsonInclude.Include.NON_NULL)
class AuthenticationDTO(var code: AuthenticationEnum, var token: String?) {
    constructor(code: AuthenticationEnum) : this(code, null)
}
