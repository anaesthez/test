package ru.nesterov.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.nesterov.result.databinding.FragmentResultBinding

class ResultFragment : Fragment(R.layout.fragment_result) {


    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}