package com.bodakesatish.composewithpaging.data.source.remote.datasource

import com.bodakesatish.composewithpaging.data.source.remote.entity.SchemeDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("mf")
    suspend fun getSchemes(): Response<List<SchemeDto>>


    @GET("mf/search")
    suspend fun getSearchMutualFundList(@Query("q") q:String): Response<List<SchemeDto>>


}