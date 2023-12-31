package com.retro2000.springbootfirstapp.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//@Entity
//@Data
class Price(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var priceId: Long = 0,

    @Column(nullable = false)
    var price: Long = 0,

    @Column(nullable = false)
    var currency: String = "",
)