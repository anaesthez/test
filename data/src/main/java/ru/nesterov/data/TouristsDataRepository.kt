package ru.nesterov.data

import ru.nesterov.data.tourists.entities.TouristEntity

interface TouristsDataRepository {

    suspend fun getTouristsList(): List<TouristEntity>

    suspend fun addTourist(touristEntity: TouristEntity)

    suspend fun deleteTourist(touristEntity: TouristEntity)

    suspend fun clearExtraTourists()
}