package com.identityservice

import com.identityservice.application.enums.AuthenticationEnum
import com.identityservice.application.service.AuthenticationService
import com.identityservice.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class IdentityServiceApplicationTests {

    @Autowired
    private lateinit var loginService: AuthenticationService

    @MockBean
    private lateinit var userRepository: UserRepository

    @Test
    fun testAuthenticationSuccess() {
        val result = this.loginService.authentication("thalys", "123456")
        assertEquals(AuthenticationEnum.SUCCESS, result.code)
    }

}
