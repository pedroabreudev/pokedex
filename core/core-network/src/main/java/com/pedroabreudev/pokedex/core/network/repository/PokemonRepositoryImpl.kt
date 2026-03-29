package com.pedroabreudev.pokedex.core.network.repository

import com.pedroabreudev.pokedex.core.network.api.PokemonApi
import com.pedroabreudev.pokedex.core.network.model.PokemonDto
import com.pedroabreudev.pokedex.core.network.model.PokemonListResponseDto
import com.pedroabreudev.pokedex.core.common.Resource


class PokemonRepositoryImpl(private val api: PokemonApi) : PokemonRepository {
    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonListResponseDto> =
        try {
            val response = api.getPokemonList(limit, offset)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e)
        }

    override suspend fun getPokemonDetail(id: Int): Resource<PokemonDto> = try {
        val response = api.getPokemonDetail(id)
        Resource.Success(response)
    } catch (e: Exception) {
        Resource.Error(e)
    }

}