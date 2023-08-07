package com.retro2000.springbootfirstapp.configuration

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
data class KeyedByFieldError(
    var field: String = "",
    override var error: String = "",
) : GenericError()

@Data
@AllArgsConstructor
@NoArgsConstructor
open class GenericError(
    open var error: String = "",
)