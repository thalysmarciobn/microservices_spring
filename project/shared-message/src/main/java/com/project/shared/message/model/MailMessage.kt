package com.project.shared.message.model

import com.project.shared.message.enums.MailTypeEnum
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class MailMessage @JsonCreator constructor(
    @JsonProperty("type") val type: MailTypeEnum,
    @JsonProperty("value") val value: String
)