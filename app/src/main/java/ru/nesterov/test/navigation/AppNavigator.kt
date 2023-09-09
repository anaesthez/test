package ru.nesterov.test.navigation

import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import ru.nesterov.booking.BookingNavigator
import ru.nesterov.hotel.HotelNavigator
import ru.nesterov.rooms.RoomsNavigator
import ru.nesterov.test.R
import javax.inject.Inject

class AppNavigator @Inject constructor(

) : HotelNavigator, RoomsNavigator, BookingNavigator {

    private var navController: NavController? = null
    private var toolbar: Toolbar? = null

    fun bindNavController(navController: NavController, toolbar: Toolbar) {
        this.navController = navController
        this.toolbar = toolbar
    }

    fun unbindNavController() {
        navController = null
        toolbar = null
    }

    override fun launchRooms(hotelName: String) {
        toolbar?.title = hotelName
        navController?.navigate(R.id.action_hotelFragment2_to_roomsFragment)
    }

    override fun launchBooking() {
        navController?.navigate(R.id.action_roomsFragment_to_bookingFragment)
    }

    override fun launchPayed() {
        navController?.navigate(R.id.action_bookingFragment_to_confirmationFragment)
    }
    fun navigateUp(): Boolean? {
        return navController?.navigateUp()
    }

    companion object {

        const val HOTEL_NAME_KEY = "hotelNameKey"
    }
}