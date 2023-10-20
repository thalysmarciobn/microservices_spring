package com.mailservice.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.*

@Configuration
class MailConfig {

    @Value("\${spring.mail.host}")
    private val host: String = "smtp.gmail.com"

    @Value("\${spring.mail.username}")
    private val username: String = ""

    @Value("\${spring.mail.password}")
    private val password: String = ""

    @Value("\${spring.mail.port}")
    private val port: Int = 587

    @Value("\${spring.mail.protocol}")
    private val protocol: String = "smtp"

    @Bean
    fun javaMailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()
        mailSender.host = this.host
        mailSender.port = this.port
        mailSender.username = this.username
        mailSender.password = this.password
        val properties: Properties = mailSender.javaMailProperties
        properties["mail.transport.protocol"] = this.protocol
        properties["mail.smtp.auth"] = "true"
        properties["mail.smtp.starttls.enable"] = "true"
        properties["mail.debug"] = "true"
        return mailSender
    }
}