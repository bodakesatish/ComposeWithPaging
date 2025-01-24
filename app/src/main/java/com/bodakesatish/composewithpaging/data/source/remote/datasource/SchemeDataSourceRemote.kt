package com.bodakesatish.composewithpaging.data.source.remote.datasource

import com.bodakesatish.composewithpaging.data.source.DataError
import com.bodakesatish.composewithpaging.data.source.remote.entity.SchemeDto
import javax.inject.Inject
import javax.inject.Singleton
import com.bodakesatish.composewithpaging.data.source.Result
import okio.IOException
import retrofit2.HttpException

@Singleton
class SchemeDataSourceRemote
@Inject
constructor(
    private val appService: ApiService
) {

    suspend fun getSchemes(): Result<List<SchemeDto>, DataError.Network> {

        val response = try {
            appService.getSchemes()
        } catch (e: IOException) {
            return Result.Error(DataError.Network.NO_INTERNET)
        } catch (e: HttpException) {
            return Result.Error(DataError.Network.SERVER_ERROR)
        } catch (e: Exception) {
            return Result.Error(DataError.Network.UNKNOWN)
        }
        return Result.Success(response.body()!!)

    }


}