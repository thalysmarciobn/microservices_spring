package com.identityservice.application.response.recovery

import com.identityservice.application.enums.RecoveryTypeResponseEnum

abstract class RecoveryResponse(
    val code: RecoveryTypeResponseEnum
)