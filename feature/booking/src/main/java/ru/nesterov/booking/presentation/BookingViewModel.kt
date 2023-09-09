package ru.nesterov.booking.presentation

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.nesterov.booking.BookingNavigator
import ru.nesterov.booking.domain.AddTouristUseCase
import ru.nesterov.booking.domain.ClearExtraTouristsUseCase
import ru.nesterov.booking.domain.GetBookingDataUseCase
import ru.nesterov.booking.domain.GetTouristsUseCase
import ru.nesterov.booking.domain.SaveTouristsUseCase
import ru.nesterov.booking.domain.entities.BookingData
import ru.nesterov.booking.domain.entities.Tourist
import ru.nesterov.booking.domain.entities.TouristData
import ru.nesterov.common.BaseViewModel
import ru.nesterov.common.Outcome
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val navigator: BookingNavigator,
    private val getBookingDataUseCase: GetBookingDataUseCase,
    private val getTouristsUseCase: GetTouristsUseCase,
    private val addTouristUseCase: AddTouristUseCase,
    private val clearExtraTouristsUseCase: ClearExtraTouristsUseCase,
    private val saveTouristsUseCase: SaveTouristsUseCase
) : BaseViewModel() {

    private val _state = MutableLiveData<Outcome<State>>(Outcome.Pending())
    val state: LiveData<Outcome<State>>
        get() = _state

    private val _touristsList = MutableLiveData<MutableList<Tourist>>()
    val touristsList: LiveData<MutableList<Tourist>>
        get() = _touristsList


    init {
        viewModelScope.launch {
            val bookingData = getBookingDataUseCase("e8868481-743f-4eb2-a0d7-2bc4012275c8")
            val tourists = getTouristsUseCase()
            _state.value = Outcome.Success(State(
                bookingData = bookingData,
                touristsData = tourists
            ))
            _touristsList.value = tourists.toMutableList()
        }
    }

    fun addTourist(number: Int) {
        viewModelScope.launch {
            addTouristUseCase(
                Tourist(
                    id = 0,
                    touristNumber = numberToString(number),
                    touristData = TouristData()
                )
            )
            val newData = getTouristsUseCase()
            _state.value = Outcome.Success(
                State(
                    bookingData = getBookingDataUseCase("e8868481-743f-4eb2-a0d7-2bc4012275c8"),
                    touristsData = newData
                )
            )
        }
    }

    private fun numberToString(number: Int): String {
        return when (number + 1) {
            3 -> "Третий турист"
            4 -> "Четвертый турист"
            5 -> "Пятый турист"
            6 -> "Шестой турист"
            7 -> "Седьмой турист"
            8 -> "Восьмой турист"
            9-> "Девятый турист"
            10 -> "Десятый турист"
            else -> "$number-й турист"
        }
    }
    fun navigateToResult() {
        val isValid = true
        if (isValid) {
            navigator.launchPayed()
        } else {
            _state.value?.let { currentState ->
                if (currentState is Outcome.Success) {
                    val updatedState = currentState.value.copy(isNameEmpty = true)
                    _state.value = Outcome.Success(updatedState)
                }
            }
        }
    }

    fun resetInputMailOrNot(isNotValid: Boolean) {
        _state.value?.let { currentState ->
            if (currentState is Outcome.Success) {
                val updatedState = currentState.value.copy(errorMailInput = isNotValid)
                _state.value = Outcome.Success(updatedState)
            }
        }
    }

    fun addTouristData(tourist: Tourist) {
        _touristsList.value?.let { currentTourists ->
            val indexToUpdate = currentTourists.indexOfFirst { it.id == tourist.id }
            if (indexToUpdate != -1) {
                currentTourists[indexToUpdate] = tourist
                _touristsList.value = currentTourists
                Log.i("DATA", "$currentTourists")
            }
        }
    }

    fun validateInputMail(mail: String) {
        val isValid = Patterns.EMAIL_ADDRESS.matcher(mail).matches()
        if (isValid) {
            resetInputMailOrNot(false)
        } else {
            resetInputMailOrNot(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            clearExtraTouristsUseCase()
        }
    }
    data class State(
        val bookingData: BookingData,
        val touristsData: List<Tourist>,
        val errorMailInput: Boolean = false,
        val isNameEmpty: Boolean = false
    )
}