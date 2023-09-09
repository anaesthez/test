package ru.nesterov.test.wiring.rooms

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.rooms.domain.repositories.RoomsRepository

@Module
@InstallIn(SingletonComponent::class)
interface RoomsRepositoriesModule {

    @Binds
    fun bindRoomsRepository(
        roomsRepositoryAdapter: RoomsRepositoryAdapter,
    ): RoomsRepository
}