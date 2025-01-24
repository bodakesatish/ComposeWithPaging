package com.bodakesatish.composewithpaging.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.bodakesatish.composewithpaging.data.source.local.entity.SchemeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SchemeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateScheme(schemeEntity: SchemeEntity): Long

    @Update
    suspend fun update(schemeEntity: SchemeEntity): Int

    @Query("DELETE FROM ${SchemeEntity.TABLE_NAME} WHERE ${SchemeEntity.Columns.SCHEME_CODE} = :schemeCode")
    fun delete(schemeCode: Int)

    @Upsert
    suspend fun upsertAll(schemes: List<SchemeEntity>)

    @Query("SELECT * FROM ${SchemeEntity.TABLE_NAME}")
    fun getSchemes(): Flow<List<SchemeEntity>>

    @Query("SELECT COUNT(*) FROM ${SchemeEntity.TABLE_NAME}")
    suspend fun getSchemesCount(): Int

}