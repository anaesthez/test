package ru.nesterov.data

import ru.nesterov.data.booking.entities.BookingDataEntity

interface BookingDataRepository {

    suspend fun getBookingData(apiKey: String) : BookingDataEntity
}