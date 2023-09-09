package ru.nesterov.data.booking.sources

import ru.nesterov.data.BookingDataRepository
import ru.nesterov.data.base.retrofit.BaseRetrofitSource
import ru.nesterov.data.base.retrofit.RetrofitConfig
import ru.nesterov.data.booking.entities.BookingDataEntity
import javax.inject.Inject

class RetrofitBookingApi @Inject constructor(
    config: RetrofitConfig
): BaseRetrofitSource(config), BookingDataRepository {

    private val bookingApi = retrofit.create(BookingApi::class.java)

    override suspend fun getBookingData(apiKey: String): BookingDataEntity = wrapRetrofitExceptions {
        bookingApi.getBookingData(apiKey)
    }

}