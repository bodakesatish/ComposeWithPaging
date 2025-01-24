package com.bodakesatish.composewithpaging.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bodakesatish.composewithpaging.data.source.local.dao.SchemeDao
import com.bodakesatish.composewithpaging.data.source.local.entity.SchemeEntity

@Database(
    entities = [
        SchemeEntity::class
    ],
     version = 1,
     exportSchema = false
)
abstract class SchemeDatabase : RoomDatabase() {
    abstract fun schemeDao(): SchemeDao
}