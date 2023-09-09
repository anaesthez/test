package ru.nesterov.rooms.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.nesterov.common.BaseViewModel
import ru.nesterov.common.Outcome
import ru.nesterov.rooms.RoomsNavigator
import ru.nesterov.rooms.domain.GetRoomsDataUseCase
import ru.nesterov.rooms.domain.entities.Room
import javax.inject.Inject

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val getRoomsDataUseCase: GetRoomsDataUseCase,
    private val navigator: RoomsNavigator
): BaseViewModel() {

    private val _state = MutableLiveData<Outcome<State>>(Outcome.Pending())
    val state: LiveData<Outcome<State>>
        get() = _state

    init {
        viewModelScope.launch {
            val data = getRoomsDataUseCase("f9a38183-6f95-43aa-853a-9c83cbb05ecd")
            _state.value = Outcome.Success(State(rooms = data))
            Log.i("DATA", "$data")
        }
    }

    fun navigateToBooking() {
        navigator.launchBooking()
    }

    data class State(
        val rooms: List<Room>
    )
}