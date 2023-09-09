package ru.nesterov.booking.domain.entities

data class TouristData(
    var name: String = "",
    val isValidName: Boolean = true,
    var surname: String = "",
    val isValidSurname: Boolean = true,
    var birthday: String = "",
    val isValidBirthday: Boolean = true,
    var citizenship: String = "",
    val isValidCitizenship: Boolean = true,
    var internationalPassportNumber: String = "",
    val isValidInternationalPassportNumber: Boolean = true,
    var internationalPassportValidity: String = "",
    val isValidInternationalPassportValidity: Boolean = true
)