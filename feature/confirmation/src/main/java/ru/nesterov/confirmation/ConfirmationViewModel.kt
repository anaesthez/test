package ru.nesterov.confirmation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.nesterov.common.BaseViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ConfirmationViewModel @Inject constructor(

) : BaseViewModel() {

    private val _orderNumber = MutableLiveData<String>()
    val orderNumber: LiveData<String>
        get() = _orderNumber

    init {
        generateOrderNumber()
    }
    private fun generateOrderNumber() {
        _orderNumber.value = UUID.randomUUID().toString()
    }
}