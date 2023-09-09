package ru.nesterov.booking.domain

import ru.nesterov.booking.domain.repositories.TouristsRepository
import javax.inject.Inject

class SaveTouristsUseCase @Inject constructor(
    private val touristsRepository: TouristsRepository
){

    suspend operator fun invoke() {
        touristsRepository.saveTourists()
    }
}