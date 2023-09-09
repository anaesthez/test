package ru.nesterov.data.rooms.sources

import ru.nesterov.data.RoomsDataRepository
import ru.nesterov.data.base.retrofit.BaseRetrofitSource
import ru.nesterov.data.base.retrofit.RetrofitConfig
import ru.nesterov.data.rooms.entities.RoomEntity
import javax.inject.Inject

class RetrofitRoomsApi @Inject constructor(
    config: RetrofitConfig
) : BaseRetrofitSource(config), RoomsDataRepository {

    private val roomsApi = retrofit.create(RoomsApi::class.java)

    override suspend fun getRoomsData(apiKey: String): List<RoomEntity> = wrapRetrofitExceptions {
        roomsApi.getRoomsData(apiKey).rooms
    }
}