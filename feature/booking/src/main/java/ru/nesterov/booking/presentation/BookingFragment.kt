package ru.nesterov.booking.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ExpandableListView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.nesterov.booking.R
import ru.nesterov.booking.databinding.FragmentBookingBinding
import ru.nesterov.booking.domain.entities.Tourist
import ru.nesterov.booking.presentation.BookingExpandableListAdapter.TouristField
import ru.nesterov.common.Outcome
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

@AndroidEntryPoint
class BookingFragment : Fragment(R.layout.fragment_booking) {

    private var _binding: FragmentBookingBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<BookingViewModel>()
    private lateinit var touristsAdapter: BookingExpandableListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBookingBinding.bind(view)
        initializeObservers()
        setupUIInteractions()
    }

    private fun initializeObservers() {
        viewModel.state.observe(viewLifecycleOwner) { bookingData ->
            when (bookingData) {
                is Outcome.Success -> setupBookingData(bookingData.value)
                is Outcome.Error -> handleError()
                is Outcome.Pending -> handleLoadingState()
            }
        }
    }

    private fun setupBookingData(data: BookingViewModel.State) = with(binding) {
        data.bookingData.apply {
            val totalPrice = tourPrice + fuelCharge + serviceCharge
            ratingNameTextView.text = ratingName
            ratingTextView.text = hoRating.toString()
            hotelNameTextView.text = hotelName
            adressTextView.text = hotelAddress
            departureTextView.text = departure
            hotelTextView.text = hotelName
            roomTextView.text = room
            arrivalCountryTextView.text = arrivalCountry
            dateTextView.text = getString(R.string.date, tourDateStart, tourDateStop)
            nightsTextView.text = numberOfNights.toString()
            nutritionTextView.text = nutrition
            tourPriceTextView.text = getString(R.string.tour_price, tourPrice)
            fuelChargeTextView.text = getString(R.string.fuel_charge_price, fuelCharge)
            serviceChargeTextView.text = getString(R.string.service_charge_price, serviceCharge)
            totalPriceTextView.text = getString(R.string.tour_price, totalPrice)
            chooseRoomButton.text = getString(R.string.total_price_button, totalPrice)
        }
        setupTouristsList(data.touristsData)
        setupFieldErrors(data.errorMailInput)
    }

    private fun handleError() {

    }

    private fun handleLoadingState() {

    }

    private fun FragmentBookingBinding.setupFieldErrors(mailError: Boolean) {
        if (mailError) {
            mailTextContainer.error = "Некорректный адрес электронной почты"
            mailTextContainer.boxStrokeColor = ContextCompat.getColor(requireContext(), R.color.input_error_color)
        } else {
            mailTextContainer.error = null
        }
        touristsAdapter.onTextChanged = { field, value, tourist ->
            when (field) {
                TouristField.NAME -> tourist.touristData.name = value
                TouristField.SURNAME -> tourist.touristData.surname = value
                TouristField.BIRTHDAY -> tourist.touristData.birthday = value
                TouristField.CITIZENSHIP -> tourist.touristData.citizenship = value
                TouristField.PASSPORT -> tourist.touristData.internationalPassportNumber = value
                TouristField.VALIDITY -> tourist.touristData.internationalPassportValidity = value
            }
            viewModel.addTouristData(tourist.copy())
        }
    }

    private fun setupUIInteractions() = with(binding) {
        setupTextWatcher()
        chooseRoomButton.setOnClickListener {
            viewModel.navigateToResult()
        }
    }

    private fun FragmentBookingBinding.setupTextWatcher() {
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        phoneEditText.addTextChangedListener(MaskFormatWatcher(mask))
        mailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetInputMailOrNot(false)
            }

            override fun afterTextChanged(input: Editable?) {

            }
        })
        mailEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                viewModel.validateInputMail(mailEditText.text.toString())
            }
        }
    }

    private fun FragmentBookingBinding.setupTouristsList(tourists: List<Tourist>) {
        touristsAdapter = BookingExpandableListAdapter(requireContext(), tourists)
        touristsExpandableListView.setAdapter(touristsAdapter)
        setupTouristClickListener(tourists)
        setListViewHeight(touristsExpandableListView, -1)
        touristsAdapter.notifyDataSetChanged()
    }

    private fun FragmentBookingBinding.setupTouristClickListener(tourists: List<Tourist>) {
        touristsExpandableListView.setOnGroupClickListener { parent, _, groupPosition, _ ->
            when {
                isLastTourist(tourists, groupPosition) -> {
                    viewModel.addTourist(groupPosition)
                    touristsAdapter.notifyDataSetChanged()
                    setListViewHeight(parent as ExpandableListView, groupPosition)
                    true
                }
                else -> {
                    setListViewHeight(parent as ExpandableListView, groupPosition)
                    false
                }
            }
        }
    }

    private fun isLastTourist(tourists: List<Tourist>, position: Int) = tourists[position] == tourists.last()

    private fun setListViewHeight(listView: ExpandableListView, group: Int) {
        val listAdapter = listView.expandableListAdapter ?: return
        var totalHeight = 0
        val desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.width, View.MeasureSpec.EXACTLY)

        for (i in 0 until listAdapter.groupCount) {
            val groupItem = listAdapter.getGroupView(i, false, null, listView)
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
            totalHeight += groupItem.measuredHeight

            if (listView.isGroupExpanded(i) && i != group || !listView.isGroupExpanded(i) && i == group) {
                for (j in 0 until listAdapter.getChildrenCount(i)) {
                    val listItem = listAdapter.getChildView(i, j, false, null, listView)
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED)
                    totalHeight += listItem.measuredHeight
                }
            }
        }

        val params = listView.layoutParams
        var height = totalHeight + (listView.dividerHeight * (listAdapter.groupCount - 1))
        if (height < 0) height = 0
        params.height = height
        listView.layoutParams = params
        listView.requestLayout()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}