package ru.nesterov.data.tourists.sources

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.nesterov.data.tourists.entities.TouristEntity

@Dao
interface TouristsDao {

    @Insert
    suspend fun saveTouristData(touristEntity: TouristEntity)

    @Delete
    suspend fun deleteTouristData(touristEntity: TouristEntity)

    @Query("SELECT * FROM tourists" )
    suspend fun getTouristsList(): List<TouristEntity>
}