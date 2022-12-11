package hu.david.urban.auth.manualsignin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.david.urban.auth.R
import hu.david.urban.auth.databinding.AuthFragmentManualSignInBinding

@AndroidEntryPoint
class ManualSignInFragment : Fragment() {

    private var _binding: AuthFragmentManualSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AuthFragmentManualSignInBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvFragmentName.text = "ManualSignInFragment"
        binding.bToPasscode.setOnClickListener {
            findNavController().navigate(R.id.action_manualSignInFragment_to_passcodeFragment)
        }
    }
}
