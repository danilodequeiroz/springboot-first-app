package com.retro2000.springbootfirstapp.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//@Entity
//@Data
class CollectibleModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var modelId: Long = 0,

    @Column(nullable = false)
    var modelType: String = "", // Mini car, Action Figure, GameDisc, GameConsole

    @Column(nullable = false)
    var brand: String = "", // Sony, Microsoft, Hot Wheels, Matchbox, Funko


)