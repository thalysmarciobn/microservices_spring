package com.service.service1.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/service1")
class Service1Controller() {

    @GetMapping
    fun get(): ResponseEntity<String> {
        return ResponseEntity.ok("OK!")
    }
}