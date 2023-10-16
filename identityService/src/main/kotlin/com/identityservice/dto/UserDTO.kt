package com.identityservice.dto

class UserDTO {
    @JvmField
    var username: String? = null
    var password: String? = null

    constructor()
    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }
}