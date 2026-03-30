package com.pedroabreudev.pokedex.feature.list.domain

import com.pedroabreudev.pokedex.core.network.model.PokemonDto
import com.pedroabreudev.pokedex.core.network.model.PokemonResultDto

private const val IMAGE_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%d.png"

fun PokemonResultDto.toPokemon(): Pokemon {
    val id = url
        .split("/")
        .filter { it.isNotEmpty() }
        .last()
        .toInt()
    return Pokemon(
        id = id,
        name = name,
        imageUrl = IMAGE_URL.format(id)
    )
}

fun PokemonDto.toPokemon(): Pokemon = Pokemon(
    id = id,
    name = name,
    imageUrl = sprites.frontDefault ?: ""
)