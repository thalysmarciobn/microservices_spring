package com.project.service.identity.application.request.recovery

import com.project.service.identity.application.enums.RecoveryTypeEnum

data class RecoveryRequest(
    val type: RecoveryTypeEnum?,
    val value: String?
)