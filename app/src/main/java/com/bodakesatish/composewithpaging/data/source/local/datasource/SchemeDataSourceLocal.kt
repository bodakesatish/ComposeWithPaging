package com.bodakesatish.composewithpaging.data.source.local.datasource

import com.bodakesatish.composewithpaging.data.mapper.local.SchemeLocalMapper.mapFromDomainModel
import com.bodakesatish.composewithpaging.data.source.local.dao.SchemeDao
import com.bodakesatish.composewithpaging.domain.model.Scheme
import javax.inject.Inject
import javax.inject.Singleton
import com.bodakesatish.composewithpaging.data.mapper.local.SchemeLocalMapper.mapToDomainModel
import com.bodakesatish.composewithpaging.data.source.local.entity.SchemeEntity
import kotlinx.coroutines.flow.Flow

@Singleton
class SchemeDataSourceLocal
@Inject
constructor(
    private val schemeDao: SchemeDao
) {

    fun getSchemeList(): Flow<List<SchemeEntity>> {
        return schemeDao.getSchemes()
    }

    suspend fun upsertSchemes(schemes: List<SchemeEntity>) {
        schemeDao.upsertAll(schemes)
    }

    suspend fun getSchemeCount(): Int {
        return schemeDao.getSchemesCount()
    }


}