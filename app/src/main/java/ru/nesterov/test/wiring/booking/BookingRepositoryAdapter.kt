package ru.nesterov.test.wiring.booking

import ru.nesterov.booking.domain.entities.BookingData
import ru.nesterov.booking.domain.repositories.BookingRepository
import ru.nesterov.data.BookingDataRepository
import ru.nesterov.test.mappers.toDomain
import javax.inject.Inject

class BookingRepositoryAdapter @Inject constructor(
    private val bookingDataRepository: BookingDataRepository
) : BookingRepository {

    override suspend fun getBookingData(apiKey: String): BookingData {
        return bookingDataRepository.getBookingData(apiKey).toDomain()

    }
}