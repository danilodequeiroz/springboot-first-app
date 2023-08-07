package com.retro2000.springbootfirstapp.model.dto

import com.retro2000.springbootfirstapp.model.User
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.validator.constraints.Length

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
    @field:NotBlank
    @field:Length(min = 4, max = 32)
    var userName: String = "",

    @Column(nullable = false)
    @field:NotNull
    @field:NotEmpty
    @field:NotBlank
    @field:Length(min = 3, max = 64)
    var firstName: String = "",

    @Column(nullable = false)
    @field:NotNull
    @field:NotEmpty
    @field:NotBlank
    @field:Length(min = 3, max = 64)
    var lastName: String = "",

    var collectible: CollectibleDto? = null,
) {
    constructor(user: User) : this() {
        this.userId = user.userId
        this.userName = user.userName
        this.firstName = user.firstName
        this.lastName = user.lastName
        user.collectible?.let { this.collectible = CollectibleDto(collectible = it) }
    }
}