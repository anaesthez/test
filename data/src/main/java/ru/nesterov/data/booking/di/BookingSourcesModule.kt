package ru.nesterov.data.booking.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.data.BookingDataRepository
import ru.nesterov.data.booking.sources.RetrofitBookingApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BookingSourcesModule {

    @Binds
    @Singleton
    fun bindHotelSource(
        retrofitBookingApi: RetrofitBookingApi
    ): BookingDataRepository
}