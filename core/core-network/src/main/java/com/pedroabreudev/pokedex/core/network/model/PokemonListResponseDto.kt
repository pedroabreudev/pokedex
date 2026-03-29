package com.pedroabreudev.pokedex.core.network.model

import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class PokemonListResponseDto(
    val count: Int,
    val results: List<PokemonResultDto>
)

@Serializable
data class PokemonResultDto(
    val name: String,
    val url: String
)
