package com.mailservice.application.message

import com.mailservice.application.enums.MailTypeEnum

data class MailMessage(
    val type: MailTypeEnum,
    val value: String
)