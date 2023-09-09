package ru.nesterov.data.hotel.entities

import com.squareup.moshi.Json

data class AboutTheHotelEntity(
    @field:Json(name = "description") val description: String,
    @field:Json(name = "peculiarities") val peculiarities: List<String> = emptyList()
)