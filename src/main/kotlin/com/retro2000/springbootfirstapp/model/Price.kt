package com.retro2000.springbootfirstapp.model

import jakarta.persistence.*
import lombok.Data

@Entity(name = "price")
@Data
class Price(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var priceId: Long = 0,

    @Column(nullable = false)
    var price: Long = 0,

    @Column(nullable = false)
    var currency: String = "",
)