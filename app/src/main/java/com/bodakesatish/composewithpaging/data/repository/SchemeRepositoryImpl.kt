package com.bodakesatish.composewithpaging.data.repository

import com.bodakesatish.composewithpaging.data.mapper.local.SchemeLocalMapper.mapToDomainModel
import com.bodakesatish.composewithpaging.data.mapper.remote.SchemeRemoteMapper.mapToDataModel
import com.bodakesatish.composewithpaging.data.source.Result
import com.bodakesatish.composewithpaging.data.source.local.datasource.SchemeDataSourceLocal
import com.bodakesatish.composewithpaging.data.source.remote.datasource.SchemeDataSourceRemote
import com.bodakesatish.composewithpaging.domain.model.Scheme
import com.bodakesatish.composewithpaging.domain.repository.SchemeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SchemeRepositoryImpl @Inject constructor(
    private val remote: SchemeDataSourceRemote,
    private val local: SchemeDataSourceLocal,
) : SchemeRepository {

    override suspend fun getSchemes(): Flow<List<Scheme>> {
        if(local.getSchemeCount() == 0) {
            when(val result = remote.getSchemes()) {
                is Result.Success -> {
                    local.upsertSchemes(result.data.map {
                        it.mapToDataModel()
                    })
                }
                is Result.Error -> {

                }
            }
        }
        val data = local.getSchemeList().map { schemes ->
            schemes.map {
                it.mapToDomainModel()
            }
        }
        return data
    }

}