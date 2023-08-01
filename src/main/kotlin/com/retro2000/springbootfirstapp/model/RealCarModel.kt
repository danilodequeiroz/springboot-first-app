package com.retro2000.springbootfirstapp.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//@Entity
//@Data
class RealCarModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var priceId: Long = 0,

    @Column(nullable = false)
    var name: String = "", // 911 GT3 RS


    @Column(nullable = false)
    var brand: String = "", // Porsche
)