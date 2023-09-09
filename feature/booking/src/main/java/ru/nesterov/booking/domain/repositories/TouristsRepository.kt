package ru.nesterov.booking.domain.repositories

import ru.nesterov.booking.domain.entities.Tourist

interface TouristsRepository {

    suspend fun addTourist(tourist: Tourist)

    suspend fun deleteTourist(tourist: Tourist)

    suspend fun getTouristsList(): List<Tourist>

    suspend fun clearExtraTourists()

    suspend fun saveTourists()
}