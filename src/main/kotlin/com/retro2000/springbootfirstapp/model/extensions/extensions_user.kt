package com.retro2000.springbootfirstapp.model.extensions

import com.retro2000.springbootfirstapp.model.User
import com.retro2000.springbootfirstapp.model.dto.UserDto
import com.retro2000.springbootfirstapp.util.SuppressNames
import java.util.stream.Collectors

@Suppress(SuppressNames.UNUSED)
fun streamToUserDtoList(users: List<User>): List<UserDto> {
    return users.stream().map { user: User ->
        UserDto(
            user
        )
    }.collect(Collectors.toList())
}

fun MutableList<User>.toUserDtoMutableList(): MutableList<UserDto> {
    return this.map { UserDto(it) }.toMutableList()
}

fun UserDto.toUser(): User {
    return User(
        userId = this.userId,
        userName = this.userName,
        firstName = this.firstName,
        lastName = this.lastName,
    )
}

fun User.toUserDto(): UserDto {
    return UserDto(
        userId = this.userId,
        userName = this.userName,
        firstName = this.firstName,
        lastName = this.lastName,
    )
}

