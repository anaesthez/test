package ru.nesterov.data.base.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.nesterov.data.tourists.entities.TouristEntity
import ru.nesterov.data.tourists.sources.TouristsDao

@Database(
    entities = [TouristEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun getTouristsDao(): TouristsDao
}