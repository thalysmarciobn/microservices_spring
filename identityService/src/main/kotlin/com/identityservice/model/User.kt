package com.identityservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var username: String? = null
    var password: String? = null
    var email: String? = null

    constructor()
    constructor(username: String?, password: String?, email: String?) {
        this.username = username
        this.password = password
        this.email = email
    }
}
