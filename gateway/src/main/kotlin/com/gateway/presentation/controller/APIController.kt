package com.gateway.presentation.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1"])
class APIController {
    @GetMapping("/ok")
    fun ok(): ResponseEntity<String> {
        return ResponseEntity.ok("ok")
    }
}