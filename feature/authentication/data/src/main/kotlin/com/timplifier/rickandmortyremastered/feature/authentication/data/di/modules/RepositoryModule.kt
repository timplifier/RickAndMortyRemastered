package com.timplifier.rickandmortyremastered.feature.authentication.data.di.modules

import com.timplifier.rickandmortyremastered.feature.authentication.data.repositories.FooRepositoryImpl
import com.timplifier.rickandmortyremastered.feature.authentication.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPhotosRepository(fooRepositoryImpl: FooRepositoryImpl): FooRepository
}