package ru.nesterov.data.rooms.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.data.RoomsDataRepository
import ru.nesterov.data.rooms.sources.RetrofitRoomsApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RoomsSourcesModule {

    @Binds
    @Singleton
    fun bindHotelSource(
        retrofitRoomsApi: RetrofitRoomsApi
    ): RoomsDataRepository

}