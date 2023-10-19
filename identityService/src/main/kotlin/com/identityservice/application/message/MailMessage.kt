package com.identityservice.application.message

import com.identityservice.application.enums.MailTypeEnum

data class MailMessage(
    val type: MailTypeEnum,
    val value: String
)