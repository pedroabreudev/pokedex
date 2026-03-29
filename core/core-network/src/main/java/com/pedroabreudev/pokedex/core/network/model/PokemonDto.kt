package com.pedroabreudev.pokedex.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class PokemonDto(
    val id: Int,
    val name: String,
    val sprites: SpritesDto
)

@Serializable
data class SpritesDto(
    @SerialName("front_default")
    val frontDefault: String?
)
