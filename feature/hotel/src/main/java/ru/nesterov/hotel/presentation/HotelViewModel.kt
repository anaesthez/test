package ru.nesterov.hotel.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.nesterov.common.BaseViewModel
import ru.nesterov.common.Outcome
import ru.nesterov.hotel.HotelNavigator
import ru.nesterov.hotel.domain.GetHotelDataUseCase
import ru.nesterov.hotel.domain.entities.Hotel
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val navigator: HotelNavigator,
    val hotelDataUseCase: GetHotelDataUseCase
) : BaseViewModel() {

    private val _state = MutableLiveData<Outcome<State>>(Outcome.Pending())
    val state: LiveData<Outcome<State>>
        get() = _state

    init {
        viewModelScope.launch {
            val hotelData = hotelDataUseCase("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
            _state.value = Outcome.Success(State(hotel = hotelData))
            Log.i("DATA", "$hotelData")
        }
    }

    fun refresh() {
        viewModelScope.launch {
            val hotelData = hotelDataUseCase("35e0d18e-2521-4f1b-a575-f0fe366f66e3")
            _state.value = Outcome.Success(State(hotel = hotelData))
            Log.i("DATA", "$hotelData")
        }
    }

    fun navigateToChooseRoom(hotelName: String) {
        navigator.launchRooms(hotelName)
    }

    data class State(
        val hotel: Hotel
    )
}