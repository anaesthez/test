package ru.nesterov.hotel.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ru.nesterov.common.Outcome
import ru.nesterov.hotel.R
import ru.nesterov.hotel.databinding.FragmentHotelBinding

@AndroidEntryPoint
class HotelFragment : Fragment(R.layout.fragment_hotel) {

    private var _binding: FragmentHotelBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HotelViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHotelBinding.bind(view)
        with(binding) {
            observeState()
        }
    }

    private fun FragmentHotelBinding.observeState() {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is Outcome.Success -> {
                    with(it.value.hotel) {
                        setupViewpager(urls = imageUrls)
                        setupHotelBlock(
                            ratingName = ratingName,
                            rating = rating,
                            hotelName = name,
                            adress = adress,
                            price = getString(R.string.price_format, minimalPrice),
                            priceForIt = priceForIt
                        )
                        setupAboutBlock(
                            peculiarities = aboutTheHotel.peculiarities,
                            description = aboutTheHotel.description
                        )
                        setupClickListeners(hotelName = name)
                    }

                }

                is Outcome.Error -> {

                }

                is Outcome.Pending -> {

                }
            }
        }
    }

    private fun FragmentHotelBinding.setupHotelBlock(
        ratingName: String,
        rating: Int,
        hotelName: String,
        adress: String,
        price: String,
        priceForIt: String
    ) {
        ratingNameTextView.text = ratingName
        ratingTextView.text = rating.toString()
        hotelNameTextView.text = hotelName
        adressTextView.text = adress
        priceTextView.text = price
        priceForItTextView.text = priceForIt
    }
    
    private fun FragmentHotelBinding.setupAboutBlock(
        description: String,
        peculiarities: List<String>
    ) {
        val textViews = listOf(firstPeculiarity, secondPeculiarity, thirdPeculiarity, fourthPeculiarity)
        textViews.forEachIndexed { index, textView ->
            textView.text = peculiarities[index]
        }
        hotelDescriptionTextView.text = description
    }

    private fun FragmentHotelBinding.setupViewpager(urls: List<String>) {
        viewPager.apply {
            clipChildren = false
            clipToPadding = false
            offscreenPageLimit = 3
            (getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
        }

        viewPager.adapter = HotelsAdapter(urls)
        TabLayoutMediator(tabLayout, viewPager) { _, _ ->

        }.attach()
    }

    private fun FragmentHotelBinding.setupClickListeners(hotelName: String) {
            chooseRoomButton.setOnClickListener {
                viewModel.navigateToChooseRoom(hotelName)
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}