package com.retro2000.springbootfirstapp.model

import jakarta.persistence.*
import lombok.Data

@Entity(name = "minis")
@Data
class Minis(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var miniId: Long = 0,

    @Column(nullable = false)
    var brand: String = "",

    @Column(nullable = false)
    var modelId: String = "",

    @OneToOne(optional = false)
    @JoinColumn(name = "pricePaid", updatable = false)
    var pricePaid: Price = Price(0, 0, "USD"),

    @OneToOne(optional = false)
    @JoinColumn(name = "evaluatedPrice", updatable = false)
    var evaluatedPrice: Price = Price(0, 0, "USD"),
)