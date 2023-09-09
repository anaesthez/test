package ru.nesterov.booking.domain

import ru.nesterov.booking.domain.entities.Tourist
import ru.nesterov.booking.domain.repositories.TouristsRepository
import javax.inject.Inject

class AddTouristUseCase @Inject constructor(private val touristsRepository: TouristsRepository) {

    suspend operator fun invoke(tourist: Tourist) {
        return touristsRepository.addTourist(tourist)
    }
}