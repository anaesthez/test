package ru.nesterov.test.wiring.rooms

import ru.nesterov.data.RoomsDataRepository
import ru.nesterov.rooms.domain.entities.Room
import ru.nesterov.rooms.domain.repositories.RoomsRepository
import ru.nesterov.test.mappers.toDomain
import javax.inject.Inject

class RoomsRepositoryAdapter @Inject constructor(
    private val roomsDataRepository: RoomsDataRepository
) : RoomsRepository {

    override suspend fun getRoomsData(apiKey: String): List<Room> {
        return roomsDataRepository.getRoomsData(apiKey).map {
            it.toDomain()
        }
    }
}