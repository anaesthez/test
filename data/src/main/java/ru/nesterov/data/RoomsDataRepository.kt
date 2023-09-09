package ru.nesterov.data

import ru.nesterov.data.rooms.entities.RoomEntity

interface RoomsDataRepository {

    suspend fun getRoomsData(apiKey: String): List<RoomEntity>
}