package com.identityservice.application.message

import com.identityservice.application.enums.RecoveryTypeEnum

data class RecoveryMessage(
    val type: RecoveryTypeEnum,
    val value: String
)