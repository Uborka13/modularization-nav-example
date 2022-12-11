package hu.david.urban.auth.scansignin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.david.urban.auth.R
import hu.david.urban.auth.databinding.AuthFragmentScanSignInBinding

@AndroidEntryPoint
class ScanSignInFragment : Fragment() {

    private var _binding: AuthFragmentScanSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AuthFragmentScanSignInBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvFragmentName.text = "ScanSignInFragment"
        binding.bToManualSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_scanSignInFragment_to_manualSignInFragment)
        }
        binding.bToPasscode.setOnClickListener {
            findNavController().navigate(R.id.action_scanSignInFragment_to_passcodeFragment)
        }
    }
}
