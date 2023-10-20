package com.identityservice.domain.repository

import com.identityservice.domain.model.User
import com.identityservice.domain.repository.projections.UserEmailProjection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface UserRepository : JpaRepository<User, Long> {
    override fun findById(id: Long): Optional<User>
    fun findByUsername(username: String): Optional<User>
    fun findByEmail(username: String): Optional<User>
    @Query("SELECT u.email as email FROM User u WHERE u.username = :username")
    fun findEmailByUsername(username: String): UserEmailProjection?
    override fun <S : User> save(entity: S): S
    override fun deleteById(id: Long)
}
