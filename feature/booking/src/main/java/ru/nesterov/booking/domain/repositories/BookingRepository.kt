package ru.nesterov.booking.domain.repositories

import ru.nesterov.booking.domain.entities.BookingData

interface BookingRepository {

    suspend fun getBookingData(apiKey: String): BookingData
}