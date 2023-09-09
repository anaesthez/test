package ru.nesterov.test.wiring.tourists

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.booking.domain.repositories.TouristsRepository

@Module
@InstallIn(SingletonComponent::class)
interface TouristsRepositoriesModule {

    @Binds
    fun bindTouristsRepository(
        touristsRepositoryAdapter: TouristsRepositoryAdapter
    ): TouristsRepository
}