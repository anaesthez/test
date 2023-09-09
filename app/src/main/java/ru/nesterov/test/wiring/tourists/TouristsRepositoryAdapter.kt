package ru.nesterov.test.wiring.tourists

import ru.nesterov.booking.domain.entities.Tourist
import ru.nesterov.booking.domain.repositories.TouristsRepository
import ru.nesterov.data.TouristsDataRepository
import ru.nesterov.test.mappers.toData
import ru.nesterov.test.mappers.toDomain
import javax.inject.Inject

class TouristsRepositoryAdapter @Inject constructor(
    private val touristsDataRepository: TouristsDataRepository
) : TouristsRepository {
    override suspend fun addTourist(tourist: Tourist) {
        touristsDataRepository.addTourist(tourist.toData())
    }

    override suspend fun deleteTourist(tourist: Tourist) {
        touristsDataRepository.deleteTourist(tourist.toData())
    }

    override suspend fun getTouristsList(): List<Tourist> =
        touristsDataRepository.getTouristsList().map {
            it.toDomain()
        }

    override suspend fun clearExtraTourists() {
        touristsDataRepository.clearExtraTourists()
    }

    override suspend fun saveTourists() {
        TODO("Not yet implemented")
    }

}