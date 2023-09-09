package ru.nesterov.confirmation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.nesterov.confirmation.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment(R.layout.fragment_confirmation) {

    private var _binding: FragmentConfirmationBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ConfirmationViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentConfirmationBinding.bind(view)
        with(binding) {
            observeState()
        }
    }

    private fun FragmentConfirmationBinding.observeState() {
        viewModel.orderNumber.observe(viewLifecycleOwner) { number ->
            orderNumberTextView.text = getString(R.string.confirmation_description, number)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}