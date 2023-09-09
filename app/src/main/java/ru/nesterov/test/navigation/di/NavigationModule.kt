package ru.nesterov.test.navigation.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import ru.nesterov.booking.BookingNavigator
import ru.nesterov.hotel.HotelNavigator
import ru.nesterov.rooms.RoomsNavigator
import ru.nesterov.test.navigation.AppNavigator


@Module
@InstallIn(ActivityRetainedComponent::class)
interface NavigationModule  {

    @Binds
    fun bindHotelNavigator(appNavigator: AppNavigator): HotelNavigator

    @Binds
    fun bindRoomsNavigator(appNavigator: AppNavigator): RoomsNavigator

    @Binds
    fun bindBookingNavigator(appNavigator: AppNavigator): BookingNavigator
}