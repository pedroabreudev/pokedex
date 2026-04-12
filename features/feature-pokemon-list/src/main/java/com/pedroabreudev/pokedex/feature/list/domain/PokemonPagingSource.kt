package com.pedroabreudev.pokedex.feature.list.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pedroabreudev.pokedex.core.common.Resource
import com.pedroabreudev.pokedex.core.network.repository.PokemonRepository

class PokemonPagingSource(private val repository: PokemonRepository) :
    PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val offset = params.key ?: 0

        return when (val result = repository.getPokemonList(
            limit = params.loadSize, offset = offset
        )) {
            is Resource.Success -> LoadResult.Page(
                data = result.data.results.map { it.toPokemon() },
                prevKey = if (offset == 0) null else offset - params.loadSize,
                nextKey = if (result.data.results.isEmpty()) null else offset + params.loadSize
            )

            is Resource.Error -> LoadResult.Error(result.exception)
            is Resource.Loading -> LoadResult.Error(Exception("Loading"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition
    }
}