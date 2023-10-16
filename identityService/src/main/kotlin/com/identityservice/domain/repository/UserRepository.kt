package com.identityservice.domain.repository

import com.identityservice.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    override fun findById(id: Long): Optional<User>
    fun findByUsername(username: String): Optional<User>
    override fun <S : User> save(entity: S): S
    override fun deleteById(id: Long)
}
