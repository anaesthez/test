package ru.nesterov.booking.domain.entities

data class Tourist (
    val id: Long = 0,
    val touristNumber: String = "",
    val touristData: TouristData = TouristData()
)