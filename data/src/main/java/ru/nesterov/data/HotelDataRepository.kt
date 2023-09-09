package ru.nesterov.data

import ru.nesterov.data.hotel.entities.HotelEntity

interface HotelDataRepository {

    suspend fun getHotelData(apiKey: String) : HotelEntity
}