package com.identityservice.application.response.recovery

import com.identityservice.application.enums.RecoveryTypeResponseEnum

class RecoveryErrorResponse(var message: String) : RecoveryResponse(RecoveryTypeResponseEnum.FAIL)