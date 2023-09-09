package ru.nesterov.hotel.domain.repository

import ru.nesterov.hotel.domain.entities.Hotel

interface HotelRepository {

    suspend fun getHotelData(apiKey: String) : Hotel
}