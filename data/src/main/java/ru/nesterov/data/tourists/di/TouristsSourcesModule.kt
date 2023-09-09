package ru.nesterov.data.tourists.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.data.TouristsDataRepository
import ru.nesterov.data.tourists.sources.RoomTouristsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface TouristsSourcesModule {

    @Binds
    @Singleton
    fun bindTouristsSource(
        roomTouristsRepository: RoomTouristsRepository
    ): TouristsDataRepository
}