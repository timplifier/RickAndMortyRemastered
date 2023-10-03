package com.timplifier.rickandmortyremastered.feature.authentication.data.di.modules

import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPhotosRepository(fooRepositoryImpl: FooRepositoryImpl): FooRepository
}