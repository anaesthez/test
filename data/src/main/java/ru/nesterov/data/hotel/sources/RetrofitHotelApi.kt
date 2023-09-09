package ru.nesterov.data.hotel.sources

import ru.nesterov.data.HotelDataRepository
import ru.nesterov.data.base.retrofit.BaseRetrofitSource
import ru.nesterov.data.base.retrofit.RetrofitConfig
import ru.nesterov.data.hotel.entities.HotelEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitHotelApi @Inject constructor(
    config: RetrofitConfig
): BaseRetrofitSource(config), HotelDataRepository {

    private val hotelApi = retrofit.create(HotelApi::class.java)

    override suspend fun getHotelData(apiKey: String): HotelEntity = wrapRetrofitExceptions {
        hotelApi.getHotelData(apiKey)
    }

}