package ru.nesterov.test.mappers

import ru.nesterov.data.hotel.entities.AboutTheHotelEntity
import ru.nesterov.data.hotel.entities.HotelEntity
import ru.nesterov.hotel.domain.entities.AboutTheHotel
import ru.nesterov.hotel.domain.entities.Hotel

// Extensions for AboutTheHotelEntity
fun AboutTheHotelEntity.toDomain(): AboutTheHotel {
    return AboutTheHotel(
        description = this.description,
        peculiarities = this.peculiarities
    )
}

fun AboutTheHotel.toEntity(): AboutTheHotelEntity {
    return AboutTheHotelEntity(
        description = this.description,
        peculiarities = this.peculiarities
    )
}

// Extensions for HotelEntity
fun HotelEntity.toDomain(): Hotel {
    return Hotel(
        id = this.id,
        name = this.name,
        adress = this.adress,
        minimalPrice = this.minimalPrice,
        priceForIt = this.priceForIt,
        rating = this.rating,
        ratingName = this.ratingName,
        imageUrls = this.imageUrls,
        aboutTheHotel = this.aboutTheHotelEntity.toDomain()
    )
}

fun Hotel.toEntity(): HotelEntity {
    return HotelEntity(
        id = this.id,
        name = this.name,
        adress = this.adress,
        minimalPrice = this.minimalPrice,
        priceForIt = this.priceForIt,
        rating = this.rating,
        ratingName = this.ratingName,
        imageUrls = this.imageUrls,
        aboutTheHotelEntity = this.aboutTheHotel.toEntity()
    )
}