package com.retro2000.springbootfirstapp.model

import jakarta.persistence.*
import lombok.Data

@Entity(name = "users")
@Data
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long = 0,

    @Column(nullable = false, unique = true)
    var userName: String = "",

    @Column(nullable = false)
    var firstName: String = "",

    @Column(nullable = false)
    var lastName: String = ""
)