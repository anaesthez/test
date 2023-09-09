package ru.nesterov.data.rooms.sources

import retrofit2.http.GET
import retrofit2.http.Path
import ru.nesterov.data.rooms.entities.RoomEntity
import ru.nesterov.data.rooms.entities.RoomResponse

interface RoomsApi {

    @GET("v3/{apiKey}")
    suspend fun getRoomsData(
        @Path("apiKey") apiKey: String,
    ) : RoomResponse
}