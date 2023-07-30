package com.retro2000.springbootfirstapp.repository

import com.retro2000.springbootfirstapp.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findByUserName(userName: String): MutableList<User>
}
