package ru.nesterov.data.hotel.sources

import retrofit2.http.GET
import retrofit2.http.Path
import ru.nesterov.data.hotel.entities.HotelEntity

interface HotelApi {

    @GET("v3/{apiKey}")
    suspend fun getHotelData(
        @Path("apiKey") apiKey: String,
    ) : HotelEntity
}