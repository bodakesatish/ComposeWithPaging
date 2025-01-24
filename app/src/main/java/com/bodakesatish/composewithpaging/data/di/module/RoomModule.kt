package com.bodakesatish.composewithpaging.data.di.module

import android.app.Application
import androidx.room.Room
import com.bodakesatish.composewithpaging.data.source.local.dao.SchemeDao
import com.bodakesatish.composewithpaging.data.source.local.database.SchemeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    private val DATABASE_NAME = "Schemes"

    @Singleton
    @Provides
    fun provideSchemeDatabase(application: Application): SchemeDatabase {
        return Room.databaseBuilder(
            application,
            SchemeDatabase::class.java, DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Singleton
    @Provides
    fun providesSchemeDao(db: SchemeDatabase): SchemeDao {
        return db.schemeDao()
    }

}