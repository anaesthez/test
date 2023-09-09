package ru.nesterov.rooms.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.nesterov.common.Outcome
import ru.nesterov.rooms.R
import ru.nesterov.rooms.databinding.FragmentRoomsBinding

@AndroidEntryPoint
class RoomsFragment : Fragment(R.layout.fragment_rooms) {

    private var _binding: FragmentRoomsBinding? = null
    private val binding get() = _binding!!

    private lateinit var roomsAdapter: RoomsAdapter

    private val viewModel by viewModels<RoomsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRoomsBinding.bind(view)
        with(binding) {
            observeState()
        }
    }

    private fun FragmentRoomsBinding.observeState() {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                is Outcome.Success -> {
                    with(binding.roomsRecyclerView) {
                        roomsAdapter = RoomsAdapter()
                        roomsAdapter.submitList(it.value.rooms)
                        adapter = roomsAdapter

                    }
                    setupClickListener()
                }

                is Outcome.Error -> {

                }

                is Outcome.Pending -> {

                }
            }
        }
    }

    private fun setupClickListener() {
        roomsAdapter.onItemClickListener = {
            viewModel.navigateToBooking()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}