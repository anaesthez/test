package ru.nesterov.data.booking.sources

import retrofit2.http.GET
import retrofit2.http.Path
import ru.nesterov.data.booking.entities.BookingDataEntity

interface BookingApi {

    @GET("v3/{apiKey}")
    suspend fun getBookingData(
        @Path("apiKey") apiKey: String,
    ) : BookingDataEntity
}