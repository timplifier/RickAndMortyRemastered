package com.timplifier.rickandmortyremastered.feature.main.data.di.modules

import com.timplifier.rickandmortyremastered.feature.main.data.repositories.FooRepositoryImpl
import com.timplifier.rickandmortyremastered.feature.main.domain.repositories.FooRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPhotosRepository(fooRepositoryImpl: FooRepositoryImpl): FooRepository
}