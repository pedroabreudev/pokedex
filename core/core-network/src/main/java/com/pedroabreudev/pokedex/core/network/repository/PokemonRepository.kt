package com.pedroabreudev.pokedex.core.network.repository

import com.pedroabreudev.pokedex.core.common.Resource
import com.pedroabreudev.pokedex.core.network.model.PokemonDto
import com.pedroabreudev.pokedex.core.network.model.PokemonListResponseDto

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int = 20, offset: Int = 0): Resource<PokemonListResponseDto>

    suspend fun getPokemonDetail(id: Int): Resource<PokemonDto>
}