package com.identityservice.application.response.recovery

import com.identityservice.application.enums.RecoveryEnum

class RecoveryErrorResponse(message: String) : RecoveryResponse(RecoveryEnum.FAIL)