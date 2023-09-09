package ru.nesterov.test.mappers

import ru.nesterov.booking.domain.entities.Tourist
import ru.nesterov.booking.domain.entities.TouristData
import ru.nesterov.data.tourists.entities.TouristEntity

fun Tourist.toData(): TouristEntity {
    return TouristEntity(
        id = this.id,
        touristNumber = this.touristNumber,
        name = this.touristData.name,
        surname = this.touristData.surname,
        birthday = this.touristData.birthday,
        citizenship = this.touristData.citizenship,
        internationalPassportNumber = this.touristData.internationalPassportNumber,
        internationalPassportValidity = this.touristData.internationalPassportValidity
    )
}

fun TouristEntity.toDomain(): Tourist {
    return Tourist(
        id = this.id,
        touristNumber = this.touristNumber,
        touristData = TouristData(
            name = this.name,
            surname = this.surname,
            birthday = this.birthday,
            citizenship = this.citizenship,
            internationalPassportNumber = this.internationalPassportNumber,
            internationalPassportValidity = this.internationalPassportValidity
        )
    )
}