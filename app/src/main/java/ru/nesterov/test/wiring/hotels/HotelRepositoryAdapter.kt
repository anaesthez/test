package ru.nesterov.test.wiring.hotels

import ru.nesterov.data.HotelDataRepository
import ru.nesterov.hotel.domain.entities.Hotel
import ru.nesterov.hotel.domain.repository.HotelRepository
import ru.nesterov.test.mappers.toDomain
import javax.inject.Inject

class HotelRepositoryAdapter @Inject constructor(
    private val hotelDataRepository: HotelDataRepository
) : HotelRepository {

    override suspend fun getHotelData(apiKey: String): Hotel {
        return hotelDataRepository.getHotelData(apiKey).toDomain()
    }
}