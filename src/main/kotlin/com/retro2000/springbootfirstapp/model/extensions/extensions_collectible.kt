package com.retro2000.springbootfirstapp.model.extensions

import com.retro2000.springbootfirstapp.model.Collectible
import com.retro2000.springbootfirstapp.model.dto.CollectibleDto

fun MutableList<Collectible>.toCollectibleDtoMutableList(): MutableList<CollectibleDto> {
    return this.map { CollectibleDto(it) }.toMutableList()
}

fun CollectibleDto.toCollectible(): Collectible {
    return Collectible(
        collectibleId = this.collectibleId,
        scale = this.scale,
        brand = this.brand,
        acquiredDate = this.acquiredDate
    )
}

fun Collectible.toCollectibleDto(): CollectibleDto {
    return CollectibleDto(
        collectibleId = this.collectibleId,
        scale = this.scale,
        brand = this.brand,
        acquiredDate = this.acquiredDate
    )
}