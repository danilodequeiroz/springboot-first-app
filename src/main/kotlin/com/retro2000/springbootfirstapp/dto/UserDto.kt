package com.retro2000.springbootfirstapp.dto

import com.retro2000.springbootfirstapp.model.User
import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.util.stream.Collectors

@AllArgsConstructor
@NoArgsConstructor
@Data
class UserDto(
    var userId: Long = 0,
    var userName: String = "",
    var firstName: String = "",
    var lastName: String = "",
) {
    constructor(user: User) : this() {
        this.userId = user.userId
        this.userName = user.userName
        this.firstName = user.firstName
        this.lastName = user.lastName
    }

    companion object {
        fun convertToUserDtoList(mutableList: MutableList<User>): MutableList<UserDto> {
            return mutableList.map { UserDto(it) }.toMutableList()
        }

        @Suppress(UNUSED)
        fun convertToUserDtoListJavaStream(users: List<User>): List<UserDto>? {
            return users.stream().map { user: User ->
                UserDto(
                    user
                )
            }.collect(Collectors.toList())
        }
    }
}