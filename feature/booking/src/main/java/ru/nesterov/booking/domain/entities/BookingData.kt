package ru.nesterov.booking.domain.entities

data class BookingData(
    val id: Int,
    val hotelName: String,
    val hotelAddress: String,
    val hoRating: Int,
    val ratingName: String,
    val departure: String,
    val arrivalCountry: String,
    val tourDateStart: String,
    val tourDateStop: String,
    val numberOfNights: Int,
    val room: String,
    val nutrition: String,
    val tourPrice: Int,
    val fuelCharge: Int,
    val serviceCharge: Int
)
