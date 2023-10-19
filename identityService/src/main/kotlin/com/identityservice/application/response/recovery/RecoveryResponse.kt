package com.identityservice.application.response.recovery

import com.identityservice.application.enums.RecoveryEnum

abstract class RecoveryResponse(
    val code: RecoveryEnum
)