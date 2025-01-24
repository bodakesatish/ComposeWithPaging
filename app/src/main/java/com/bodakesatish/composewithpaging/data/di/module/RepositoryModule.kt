package com.bodakesatish.composewithpaging.data.di.module

import com.bodakesatish.composewithpaging.data.repository.SchemeRepositoryImpl
import com.bodakesatish.composewithpaging.data.source.local.datasource.SchemeDataSourceLocal
import com.bodakesatish.composewithpaging.data.source.remote.datasource.SchemeDataSourceRemote
import com.bodakesatish.composewithpaging.domain.repository.SchemeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    internal abstract fun provideSchemeRepository(schemeRepository: SchemeRepositoryImpl): SchemeRepository

//    @Binds
//    internal abstract fun provideSchemeDataSourceLocal(schemeRepository: SchemeDataSourceLocal): SchemeDataSourceLocal
//
//    @Binds
//    internal abstract fun provideSchemeDataSourceRemote(schemeRepository: SchemeDataSourceRemote): SchemeDataSourceRemote

}