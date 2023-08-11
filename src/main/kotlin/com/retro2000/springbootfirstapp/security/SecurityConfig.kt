package com.retro2000.springbootfirstapp.security

import com.retro2000.springbootfirstapp.controller.CollectibleController.Companion.COLLECTIBLES_PATH
import com.retro2000.springbootfirstapp.util.SuppressNames
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
@Configuration
@Suppress(SuppressNames.UNUSED)
class SecurityConfig {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http.authorizeHttpRequests {
            it.requestMatchers(
                HttpMethod.GET, COLLECTIBLES_PATH
            ).permitAll()
        }.build()
    }
}