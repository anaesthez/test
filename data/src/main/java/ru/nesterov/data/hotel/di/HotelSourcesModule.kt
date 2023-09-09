package ru.nesterov.data.hotel.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.data.HotelDataRepository
import ru.nesterov.data.hotel.sources.HotelApi
import ru.nesterov.data.hotel.sources.RetrofitHotelApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface HotelSourcesModule {

    @Binds
    @Singleton
    fun bindHotelSource(
        retrofitHotelApi: RetrofitHotelApi
    ): HotelDataRepository
}