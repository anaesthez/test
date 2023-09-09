package ru.nesterov.data.rooms.entities

import com.squareup.moshi.Json

data class RoomResponse (
    @field:Json(name = "rooms") val rooms: List<RoomEntity>
)
data class RoomEntity (
    @field:Json(name = "id")val id: Long,
    @field:Json(name = "name")val name: String,
    @field:Json(name = "price")val price: Long,
    @field:Json(name = "price_per")val pricePer: String,
    @field:Json(name = "peculiarities")val peculiarities: List<String>,
    @field:Json(name = "image_urls")val imageUrls: List<String>
)
