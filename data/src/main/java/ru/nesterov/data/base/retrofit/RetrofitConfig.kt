package ru.nesterov.data.base.retrofit

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitConfig @Inject constructor (
    val retrofit: Retrofit,
    val moshi: Moshi
)