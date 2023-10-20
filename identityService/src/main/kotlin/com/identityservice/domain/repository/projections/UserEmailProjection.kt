package com.identityservice.domain.repository.projections

import org.springframework.beans.factory.annotation.Value;

interface UserEmailProjection {
    @Value("#{target.email}")
    fun getEmail(): String?
}