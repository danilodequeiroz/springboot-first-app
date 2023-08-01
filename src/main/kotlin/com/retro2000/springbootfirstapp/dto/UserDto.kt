package com.retro2000.springbootfirstapp.dto

import com.retro2000.springbootfirstapp.model.User
import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.validator.constraints.Length
import java.util.stream.Collectors

@AllArgsConstructor
@NoArgsConstructor
@Data
class UserDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long = 0,

    @Column(nullable = false, unique = true)
    @field:NotNull
    @field:NotEmpty
    @field:Length(min = 4, max = 32)
    var userName: String = "",

    @Column(nullable = false)
    @field:NotNull
    @field:NotEmpty
    @field:Length(min = 4, max = 64)
    var firstName: String = "",

    @Column(nullable = false)
    @field:NotNull
    @field:NotEmpty
    @field:Length(min = 4, max = 64)
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

        fun convertToUser(user: UserDto): User {
            return User(
                userId = user.userId,
                userName = user.userName,
                firstName = user.firstName,
                lastName = user.lastName,
            )
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