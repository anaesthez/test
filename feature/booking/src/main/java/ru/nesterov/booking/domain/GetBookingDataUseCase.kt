package ru.nesterov.booking.domain

import ru.nesterov.booking.domain.entities.BookingData
import ru.nesterov.booking.domain.repositories.BookingRepository
import javax.inject.Inject

class GetBookingDataUseCase @Inject constructor(private val bookingRepository: BookingRepository) {

    suspend operator fun invoke(apiKey: String) : BookingData {
        return bookingRepository.getBookingData(apiKey)
    }
}