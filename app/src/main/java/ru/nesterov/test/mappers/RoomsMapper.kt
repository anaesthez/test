package ru.nesterov.test.mappers

import ru.nesterov.data.rooms.entities.RoomEntity
import ru.nesterov.rooms.domain.entities.Room

fun RoomEntity.toDomain(): Room {
//    return Room(
//        id = this.id,
//        hotelName = this.hotelName,
//        hotelAddress = this.hotelAddress,
//        hoRating = this.hoRating,
//        ratingName = this.ratingName,
//        departure = this.departure,
//        arrivalCountry = this.arrivalCountry,
//        tourDateStart = this.tourDateStart,
//        tourDateStop = this.tourDateStop,
//        numberOfNights = this.numberOfNights,
//        room = this.room,
//        nutrition = this.nutrition,
//        tourPrice = this.tourPrice,
//        fuelCharge = this.fuelCharge,
//        serviceCharge = this.serviceCharge
//    )
    return Room(
    id = this.id,
    name = this.name,
    price = this.price,
    pricePer = this.pricePer,
    peculiarities = this.peculiarities,
    imageUrls = this.imageUrls
    )
}
