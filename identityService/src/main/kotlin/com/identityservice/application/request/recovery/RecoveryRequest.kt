package com.identityservice.application.request.recovery

data class RecoveryRequest(
    val type: String?,
    val value: String?
)