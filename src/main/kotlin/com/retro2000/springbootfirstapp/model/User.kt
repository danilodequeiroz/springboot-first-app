package com.retro2000.springbootfirstapp.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import lombok.Data
import org.hibernate.validator.constraints.Length

@Entity
@Data
class User(
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

    @ManyToOne
    var collectible: Collectible? = null,
)