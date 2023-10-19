package com.service.service1.application.message

import com.service.service1.application.enums.MailTypeEnum

data class MailMessage(
    val type: MailTypeEnum,
    val value: String
)