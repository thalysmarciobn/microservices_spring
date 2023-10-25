package com.project.service.identity.application.response.recovery

import com.project.service.identity.application.enums.RecoveryTypeEnum
import com.project.service.identity.application.enums.RecoveryTypeResponseEnum

class RecoverySentResponse(var type: RecoveryTypeEnum, var message: String) : RecoveryResponse(RecoveryTypeResponseEnum.SENT)