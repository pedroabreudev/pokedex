package com.pedroabreudev.pokedex.feature.list.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pedroabreudev.pokedex.core.network.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonPagingUseCase @Inject constructor(private val repository: PokemonRepository) {
    operator fun invoke(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { PokemonPagingSource(repository) }
        ).flow
    }
}