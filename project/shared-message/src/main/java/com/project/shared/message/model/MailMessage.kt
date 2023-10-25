package com.project.shared.message.model

import com.project.shared.message.enums.MailTypeEnum

data class MailMessage(
    val type: MailTypeEnum,
    val value: String
)