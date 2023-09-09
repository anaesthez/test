package ru.nesterov.data.booking.entities

import com.squareup.moshi.Json

data class BookingDataEntity(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "hotel_name") val hotelName: String,
    @field:Json(name = "hotel_adress") val hotelAddress: String,
    @field:Json(name = "horating") val hoRating: Int,
    @field:Json(name = "rating_name") val ratingName: String,
    @field:Json(name = "departure") val departure: String,
    @field:Json(name = "arrival_country") val arrivalCountry: String,
    @field:Json(name = "tour_date_start") val tourDateStart: String,
    @field:Json(name = "tour_date_stop") val tourDateStop: String,
    @field:Json(name = "number_of_nights") val numberOfNights: Int,
    @field:Json(name = "room") val room: String,
    @field:Json(name = "nutrition") val nutrition: String,
    @field:Json(name = "tour_price") val tourPrice: Int,
    @field:Json(name = "fuel_charge") val fuelCharge: Int,
    @field:Json(name = "service_charge") val serviceCharge: Int
)
