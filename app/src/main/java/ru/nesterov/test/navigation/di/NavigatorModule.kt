package ru.nesterov.test.navigation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.nesterov.test.navigation.AppNavigator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigatorModule {

    @Singleton
    @Provides
    fun provideAppNavigator() = AppNavigator()
}