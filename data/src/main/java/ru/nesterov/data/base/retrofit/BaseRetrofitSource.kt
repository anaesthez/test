package ru.nesterov.data.base.retrofit

import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import retrofit2.Retrofit
import ru.nesterov.common.AppException
import ru.nesterov.common.ConnectionException
import ru.nesterov.common.ParseBackendResponseException
import java.io.IOException

open class BaseRetrofitSource(
    config: RetrofitConfig
) {

    val retrofit: Retrofit = config.retrofit

    private val moshi: Moshi = config.moshi

    suspend fun <T> wrapRetrofitExceptions(block: suspend () -> T): T {
        return try {
            block()
        } catch (e: AppException) {
            throw e
            // moshi
        } catch (e: JsonDataException) {
            throw ParseBackendResponseException(e)
        } catch (e: JsonEncodingException) {
            throw ParseBackendResponseException(e)
            // retrofit
        } catch (e: HttpException) {
            throw ParseBackendResponseException(e)
            // mostly retrofit
        } catch (e: IOException) {
            throw ConnectionException(e)
        }
    }
}