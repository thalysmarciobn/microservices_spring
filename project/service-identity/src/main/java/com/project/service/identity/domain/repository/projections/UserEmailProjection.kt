package com.project.service.identity.domain.repository.projections

import org.springframework.beans.factory.annotation.Value;

interface UserEmailProjection {
    @Value("#{target.email}")
    fun getEmail(): String?
}