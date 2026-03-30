package com.pedroabreudev.pokedex.feature.list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedroabreudev.pokedex.core.common.Resource
import com.pedroabreudev.pokedex.feature.list.domain.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val useCase: GetPokemonListUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokemonListState>(PokemonListState.Loading)
    val uiState: StateFlow<PokemonListState> = _uiState.asStateFlow()

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            _uiState.value = PokemonListState.Loading
            when (val result = useCase()) {
                is Resource.Success -> _uiState.value = PokemonListState.Success(result.data)
                is Resource.Error -> _uiState.value = PokemonListState.Error(result.exception)
                is Resource.Loading -> _uiState.value = PokemonListState.Loading
            }
        }
    }
}