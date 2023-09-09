package ru.nesterov.data.tourists.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "tourists"
)
data class TouristEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "tourist_number")val touristNumber: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "surname") val surname: String,
    @ColumnInfo(name = "birthday") val birthday: String,
    @ColumnInfo(name = "citizenship") val citizenship: String,
    @ColumnInfo(name = "international_passport_number") val internationalPassportNumber: String,
    @ColumnInfo(name = "international_passport_validity") val internationalPassportValidity: String
)
