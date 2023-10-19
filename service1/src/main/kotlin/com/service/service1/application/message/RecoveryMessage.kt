package com.service.service1.application.message

import com.service.service1.application.enums.RecoveryTypeEnum

data class RecoveryMessage(
    val type: RecoveryTypeEnum,
    val value: String
)