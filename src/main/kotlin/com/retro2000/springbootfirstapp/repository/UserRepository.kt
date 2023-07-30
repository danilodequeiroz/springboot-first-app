package com.retro2000.springbootfirstapp.repository

import com.retro2000.springbootfirstapp.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findByUserName(userName: String): MutableList<User>
    fun deleteByUserId(userId: Long): User
}
