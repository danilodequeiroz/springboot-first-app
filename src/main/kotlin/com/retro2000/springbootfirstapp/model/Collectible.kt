package com.retro2000.springbootfirstapp.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import lombok.Data
import java.time.LocalDate

@Entity
@Data
class Collectible(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var collectibleId: Long = 0,

    @field:NotEmpty
    @field:NotNull
    @Column(nullable = false)
    var brand: String = "",

//    @NotEmpty
//    @NotNull
//    @Column(nullable = false)
//    var modelId: String = "",

    @field:NotEmpty
    @field:NotNull
    @Column(nullable = false)
    var scale: String = "1:64",

    @field:NotNull
    @Column(nullable = false)
    var acquiredDate: LocalDate = LocalDate.EPOCH,

//    @OneToOne(optional = false)
//    @JoinColumn(name = "pricePaid", updatable = false)
//    var pricePaid: Price = Price(0, 0, "USD"),
//
//    @OneToOne(optional = false)
//    @JoinColumn(name = "evaluatedPrice", updatable = false)
//    var evaluatedPrice: Price = Price(0, 0, "USD"),
)