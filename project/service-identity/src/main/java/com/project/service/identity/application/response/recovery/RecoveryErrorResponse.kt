package com.project.service.identity.application.response.recovery

import com.project.service.identity.application.enums.RecoveryTypeResponseEnum

class RecoveryErrorResponse(var message: String) : RecoveryResponse(RecoveryTypeResponseEnum.FAIL)