package ru.nesterov.test.mappers

import ru.nesterov.booking.domain.entities.BookingData
import ru.nesterov.data.booking.entities.BookingDataEntity

fun BookingDataEntity.toDomain(): BookingData {
    return BookingData(
        id = this.id,
        hotelName = this.hotelName,
        hotelAddress = this.hotelAddress,
        hoRating = this.hoRating,
        ratingName = this.ratingName,
        departure = this.departure,
        arrivalCountry = this.arrivalCountry,
        tourDateStart = this.tourDateStart,
        tourDateStop = this.tourDateStop,
        numberOfNights = this.numberOfNights,
        room = this.room,
        nutrition = this.nutrition,
        tourPrice = this.tourPrice,
        fuelCharge = this.fuelCharge,
        serviceCharge = this.serviceCharge
    )
}