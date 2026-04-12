package com.pedroabreudev.pokedex.feature.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.pedroabreudev.pokedex.feature.list.domain.GetPokemonPagingUseCase
import com.pedroabreudev.pokedex.feature.list.domain.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonPagingUseCase: GetPokemonPagingUseCase
) : ViewModel() {

    val pokemonPagingFlow: Flow<PagingData<Pokemon>> =
        getPokemonPagingUseCase().cachedIn(viewModelScope)
}