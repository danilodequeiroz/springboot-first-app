package com.retro2000.springbootfirstapp.controller

import com.retro2000.springbootfirstapp.model.User
import com.retro2000.springbootfirstapp.model.dto.UserDto
import com.retro2000.springbootfirstapp.model.extensions.toUser
import com.retro2000.springbootfirstapp.model.extensions.toUserDtoMutableList
import com.retro2000.springbootfirstapp.repository.UserRepository
import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/users")
@Suppress(UNUSED)
class UserController {

    companion object {
        const val USER_ID = "/{userId}"
    }

    @Autowired
    private lateinit var userRepository: UserRepository

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody userDto: UserDto): ResponseEntity<User> {
        return if (userRepository.findByUserName(userDto.userName).isEmpty()) {
            userRepository.save(userDto.toUser())
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.unprocessableEntity().build()
        }
    }

    @GetMapping
    @ResponseBody
    fun getUsers(): MutableList<UserDto> {
        return userRepository.findAll().toUserDtoMutableList()
    }

    //    @GetMapping(USER_ID)
    fun findByIdOrElseThrow(@PathVariable userId: Long): User {
        return userRepository.findById(userId).orElseThrow {
            ResponseStatusException(
                HttpStatus.BAD_REQUEST, "User with userId of value $userId was not found."
            )
        }
    }

    @GetMapping(USER_ID)
    @ResponseStatus(HttpStatus.CREATED)
    fun findById(@PathVariable userId: Long): ResponseEntity<UserDto> {
        val userOptional = userRepository.findById(userId)
        if (userOptional.isPresent) {
            return ResponseEntity.ok(UserDto(userOptional.get()))
        }
        return ResponseEntity.notFound().build()
    }

    @PutMapping(USER_ID)
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

    @DeleteMapping(USER_ID)
    fun delete(@PathVariable userId: Long): ResponseEntity<HashMap<String, Any>> {
        return if (!userRepository.existsById(userId)) {
            ResponseEntity.notFound().build()
        } else {
            userRepository.deleteById(userId)
            ResponseEntity.noContent().build()
        }
    }

    @PatchMapping(USER_ID)
    fun updateOrModifyUserNameById(
        @PathVariable userId: Long, @RequestParam("userName") userName: String
    ): ResponseEntity<HashMap<String, Any>> {
        return if (!userRepository.existsById(userId)) {
            ResponseEntity.unprocessableEntity().build()
        } else {
            val user = userRepository.findById(userId).get()
            val oldUsername = user.userName
            user.userName = userName
            userRepository.save(user)
            ResponseEntity.ok(
                hashMapOf(
                    Pair("changes", "userName changed from `$oldUsername` to `${user.userName}`"),
                    Pair<String, Any>("user", user),
                )
            )
        }
    }
}