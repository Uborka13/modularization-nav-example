package hu.david.urban.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import hu.david.urban.main.databinding.MainFragmentMainBinding

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: MainFragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentMainBinding.inflate(inflater)
        arguments?.let { bundle ->
            binding.tvUserName.text = bundle.getString("username")
        }
        binding.tvFragmentName.text = "MainFragment"
        return binding.root
    }
}
