package com.retro2000.springbootfirstapp.model.dto

import com.retro2000.springbootfirstapp.model.Collectible
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import java.time.LocalDate

@AllArgsConstructor
@NoArgsConstructor
@Data
class CollectibleDto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var collectibleId: Long = 0,

    @field:NotEmpty
    @field:NotNull
    @Column(nullable = false)
    var brand: String = "",

    @field:NotEmpty
    @field:NotNull
    @Column(nullable = false)
    var scale: String = "1:64",

    @field:NotNull
    @Column(nullable = false)
    var acquiredDate: LocalDate = LocalDate.EPOCH
) {
    constructor(collectible: Collectible) : this() {
        this.collectibleId = collectible.collectibleId
        this.acquiredDate = collectible.acquiredDate
        this.brand = collectible.brand
        this.scale = collectible.scale
    }
}