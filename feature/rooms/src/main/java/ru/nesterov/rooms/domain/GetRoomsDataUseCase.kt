package ru.nesterov.rooms.domain

import ru.nesterov.rooms.domain.entities.Room
import ru.nesterov.rooms.domain.repositories.RoomsRepository
import javax.inject.Inject

class GetRoomsDataUseCase @Inject constructor(private val roomsRepository: RoomsRepository) {

    suspend operator fun invoke(apiKey: String) : List<Room> {
        return roomsRepository.getRoomsData(apiKey)
    }
}