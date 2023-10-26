package com.project.service.identity.application.response.recovery

import com.project.service.identity.application.enums.RecoveryTypeResponseEnum

abstract class RecoveryResponse(
    val code: RecoveryTypeResponseEnum
)