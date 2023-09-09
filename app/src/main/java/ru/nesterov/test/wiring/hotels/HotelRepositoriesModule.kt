package ru.nesterov.test.wiring.hotels

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.hotel.domain.repository.HotelRepository

@Module
@InstallIn(SingletonComponent::class)
interface HotelRepositoriesModule {

    @Binds
    fun bindHotelRepository(
        hotelRepositoryAdapter: HotelRepositoryAdapter,
    ): HotelRepository

}