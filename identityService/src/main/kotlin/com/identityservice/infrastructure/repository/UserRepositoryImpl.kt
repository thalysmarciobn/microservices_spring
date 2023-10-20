package com.identityservice.infrastructure.repository

import com.identityservice.domain.model.User
import com.identityservice.domain.repository.UserRepository
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Repository
import java.util.*
import java.util.function.Function

@Repository
class UserRepositoryImpl : UserRepository {

    @Autowired
    private lateinit var entityManager: EntityManager

    fun findEmailByUsername(username: String): Optional<String> {
        val query = this.entityManager.createQuery("SELECT u.email FROM User u WHERE u.username = :username", String::class.java)
        query.setParameter("username", username)

        val result = query.resultList
        return if (result.isNotEmpty()) {
            Optional.of(result[0])
        } else {
            Optional.empty()
        }
    }

    override fun findById(id: Long): Optional<User> {
        TODO("Not yet implemented")
    }

    override fun findByUsername(username: String): Optional<User> {
        TODO("Not yet implemented")
    }

    override fun findByEmail(username: String): Optional<User> {
        TODO("Not yet implemented")
    }

    override fun <S : User> save(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun <S : User?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : User?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : User?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<User> {
        TODO("Not yet implemented")
    }

    override fun <S : User?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableList<User> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : User?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: User) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Long>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<User>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : User?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : User?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : User?, R : Any> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>,
    ): R {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : User> saveAndFlush(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : User?> saveAllAndFlush(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch(entities: MutableIterable<User>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun deleteAllByIdInBatch(ids: MutableIterable<Long>) {
        TODO("Not yet implemented")
    }

    override fun getReferenceById(id: Long): User {
        TODO("Not yet implemented")
    }

    @Deprecated("Deprecated in Java")
    override fun getById(id: Long): User {
        TODO("Not yet implemented")
    }

    @Deprecated("Deprecated in Java")
    override fun getOne(id: Long): User {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Long): Boolean {
        TODO("Not yet implemented")
    }
}