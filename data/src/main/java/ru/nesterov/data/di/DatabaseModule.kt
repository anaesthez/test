package ru.nesterov.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.nesterov.data.base.room.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideTouristsDatabase(@ApplicationContext app: Context) = Room
        .databaseBuilder(app, AppDatabase::class.java, "tourists")
        .createFromAsset("tourists_init.db")
        .build()

    @Singleton
    @Provides
    fun provideTouristsDao(db: AppDatabase) = db.getTouristsDao()
}