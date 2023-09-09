package ru.nesterov.booking.domain

import ru.nesterov.booking.domain.repositories.TouristsRepository
import javax.inject.Inject

class ClearExtraTouristsUseCase @Inject constructor(private val touristsRepository: TouristsRepository) {

    suspend operator fun invoke() {
        return touristsRepository.clearExtraTourists()
    }
}