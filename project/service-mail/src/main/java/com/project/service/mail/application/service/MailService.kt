package com.project.service.mail.application.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailService @Autowired constructor(private val javaMailSender: JavaMailSender) {
    fun send(to: String?, subject: String?, text: String?) {
        val message = SimpleMailMessage()
        message.setTo(to)
        message.subject = subject
        message.text = text
        this.javaMailSender.send(message)
    }
}