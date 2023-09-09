package ru.nesterov.data.tourists.sources

import android.util.Log
import ru.nesterov.data.TouristsDataRepository
import ru.nesterov.data.tourists.entities.TouristEntity
import javax.inject.Inject

class RoomTouristsRepository @Inject constructor(
    private val touristsDao: TouristsDao
): TouristsDataRepository {
    override suspend fun getTouristsList(): List<TouristEntity> {
        Log.i("DATA_LAYER", "${touristsDao.getTouristsList()}")
        return touristsDao.getTouristsList()
    }

    override suspend fun addTourist(touristEntity: TouristEntity) {
        val touristsLast = touristsDao.getTouristsList().last()
        with(touristsDao) {
            deleteTouristData(touristsLast)
            saveTouristData(touristEntity)
            saveTouristData(touristsLast.copy(
                id = 0
            ))
        }
    }

    override suspend fun deleteTourist(touristEntity: TouristEntity) {
        touristsDao.deleteTouristData(touristEntity)
    }

    override suspend fun clearExtraTourists() {
        val list = touristsDao.getTouristsList()

        if (list.size <= 3) return

        val toKeep = mutableListOf<TouristEntity>()

        toKeep.add(list[0])
        toKeep.add(list[1])
        toKeep.add(list.last())

        val toDelete = list.filter { it !in toKeep }

        toDelete.forEach {
            touristsDao.deleteTouristData(it)
        }
    }

}