package com.retro2000.springbootfirstapp.controller

import com.retro2000.springbootfirstapp.model.User
import com.retro2000.springbootfirstapp.repository.UserRepository
import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@Suppress(UNUSED)
class UserController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @GetMapping
    @ResponseBody
    fun getUsers(): MutableList<User> {
        return userRepository.findAll()
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody user: User): ResponseEntity<User> {
        return if (userRepository.findByUserName(user.userName).isEmpty()) {
            userRepository.save(user)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.unprocessableEntity().build()
        }
    }


    @PutMapping("/{userId}")
    @ResponseBody
    fun updateOrReplace(@PathVariable userId: Long, @RequestBody user: User): ResponseEntity<User> {
        return if (!userRepository.existsById(userId)) {
            ResponseEntity.notFound().build()
        } else if (userRepository.findByUserName(user.userName).isNotEmpty()) {
            ResponseEntity.unprocessableEntity().build()
        } else {
            user.userId = userId
            userRepository.save(user)
            ResponseEntity.ok(user)
        }
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    fun delete(@PathVariable userId: Long): ResponseEntity<User> {
        return if (!userRepository.existsById(userId)) {
            ResponseEntity.notFound().build()
        } else {
            userRepository.deleteByUserId(userId)
            ResponseEntity.noContent().build()
        }
    }

//    @PatchMapping("/{userId}")
//    fun updateOrModifyUserNameById(@PathVariable userId: Long, @RequestParam userName: String): ResponseEntity<User> {
//        return if (userRepository.existsById(userId)) {
//            ResponseEntity.unprocessableEntity().build()
//        } else {
//            val user = userRepository.findById(userId).get()
//            user.userName = userName
//            ResponseEntity.ok(user)
//        }
//    }
}