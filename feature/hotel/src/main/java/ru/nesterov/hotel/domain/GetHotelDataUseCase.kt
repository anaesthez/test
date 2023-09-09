package ru.nesterov.hotel.domain

import ru.nesterov.hotel.domain.entities.Hotel
import ru.nesterov.hotel.domain.repository.HotelRepository
import javax.inject.Inject

class GetHotelDataUseCase @Inject constructor(private val hotelRepository: HotelRepository) {

    suspend operator fun invoke(apiKey: String) : Hotel {
        return hotelRepository.getHotelData(apiKey)
    }
}