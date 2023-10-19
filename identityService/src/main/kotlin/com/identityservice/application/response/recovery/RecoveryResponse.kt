package com.identityservice.application.response.recovery

import com.identityservice.application.enums.RecoveryTypeEnum

abstract class RecoveryResponse(
    val code: RecoveryTypeEnum
)