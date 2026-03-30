package com.pedroabreudev.pokedex.feature.list.domain

import com.pedroabreudev.pokedex.core.common.Resource
import com.pedroabreudev.pokedex.core.network.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke(
        limit: Int = 20,
        offset: Int = 0
    ): Resource<List<Pokemon>> {
        return when (val result = repository.getPokemonList(limit, offset)) {
            is Resource.Success -> Resource.Success(
                result.data.results.map { it.toPokemon() }
            )

            is Resource.Error -> Resource.Error(result.exception)
            is Resource.Loading -> Resource.Loading
        }
    }
}