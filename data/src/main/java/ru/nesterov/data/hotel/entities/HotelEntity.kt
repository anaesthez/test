package ru.nesterov.data.hotel.entities

import com.squareup.moshi.Json

data class HotelEntity(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "adress") val adress: String,
    @field:Json(name = "minimal_price") val minimalPrice: Int,
    @field:Json(name = "price_for_it") val priceForIt: String,
    @field:Json(name = "rating") val rating: Int,
    @field:Json(name = "rating_name") val ratingName: String,
    @field:Json(name = "image_urls") val imageUrls: List<String>,
    @field:Json(name = "about_the_hotel") val aboutTheHotelEntity: AboutTheHotelEntity,
)