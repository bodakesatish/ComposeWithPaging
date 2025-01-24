package com.bodakesatish.composewithpaging.domain.repository

import com.bodakesatish.composewithpaging.domain.model.Scheme
import kotlinx.coroutines.flow.Flow

interface SchemeRepository {
    suspend fun getSchemes(): Flow<List<Scheme>>
}