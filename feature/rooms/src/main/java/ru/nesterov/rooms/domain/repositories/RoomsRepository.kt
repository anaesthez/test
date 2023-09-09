package ru.nesterov.rooms.domain.repositories

import ru.nesterov.rooms.domain.entities.Room

interface RoomsRepository {

    suspend fun getRoomsData(apiKey: String): List<Room>
}