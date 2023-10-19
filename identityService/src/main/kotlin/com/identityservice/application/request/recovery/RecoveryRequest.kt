package com.identityservice.application.request.recovery

import com.identityservice.application.enums.RecoveryTypeEnum

data class RecoveryRequest(
    val type: RecoveryTypeEnum?,
    val value: String?
)
