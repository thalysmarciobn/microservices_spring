package com.identityservice.application.response.recovery

import com.identityservice.application.enums.RecoveryTypeEnum
import com.identityservice.application.enums.RecoveryTypeResponseEnum

class RecoverySentResponse(var type: RecoveryTypeEnum) : RecoveryResponse(RecoveryTypeResponseEnum.SENT)