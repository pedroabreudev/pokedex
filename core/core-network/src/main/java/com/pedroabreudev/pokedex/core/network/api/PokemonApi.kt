package com.pedroabreudev.pokedex.core.network.api

import com.pedroabreudev.pokedex.core.network.model.PokemonDto
import com.pedroabreudev.pokedex.core.network.model.PokemonListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonListResponseDto

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(
        @Path("id") id: Int
    ): PokemonDto
}