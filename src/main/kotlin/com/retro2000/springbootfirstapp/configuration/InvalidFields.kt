package com.retro2000.springbootfirstapp.configuration

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
class InvalidFields(
    var field: String = "",
    var error: String = "",
)