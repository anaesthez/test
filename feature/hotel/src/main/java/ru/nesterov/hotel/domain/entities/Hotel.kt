package ru.nesterov.hotel.domain.entities

data class Hotel (
    val id: Int,
    val name: String,
    val adress: String,
    val minimalPrice: Int,
    val priceForIt: String,
    val rating: Int,
    val ratingName: String,
    val imageUrls: List<String>,
    val aboutTheHotel: AboutTheHotel
)