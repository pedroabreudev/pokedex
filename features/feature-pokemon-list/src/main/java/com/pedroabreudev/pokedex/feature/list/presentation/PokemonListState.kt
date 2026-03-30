package com.pedroabreudev.pokedex.feature.list.presentation

import com.pedroabreudev.pokedex.feature.list.domain.Pokemon

sealed class PokemonListState {
    object Loading : PokemonListState()
    data class Success(val pokemons: List<Pokemon>) : PokemonListState()
    data class Error(val exception: Throwable) : PokemonListState()
    object Empty : PokemonListState()
}