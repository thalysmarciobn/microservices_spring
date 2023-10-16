package com.identityservice.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "username")
    var username: String? = null

    @Column(name = "password")
    var password: String? = null

    @Column(name = "email")
    var email: String? = null

    constructor()
    constructor(username: String?, password: String?, email: String?) {
        this.username = username
        this.password = password
        this.email = email
    }
}
