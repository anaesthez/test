package ru.nesterov.test.wiring.booking

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.booking.domain.repositories.BookingRepository

@Module
@InstallIn(SingletonComponent::class)
interface BookingRepositoriesModule {

    @Binds
    fun bindBookingRepository(
        bookingRepositoryAdapter: BookingRepositoryAdapter,
    ): BookingRepository
}