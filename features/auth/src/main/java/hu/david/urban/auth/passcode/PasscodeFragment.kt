package hu.david.urban.auth.passcode

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.david.urban.auth.R
import hu.david.urban.auth.databinding.AuthFragmentPasscodeBinding

@AndroidEntryPoint
class PasscodeFragment : Fragment() {

    private var _binding: AuthFragmentPasscodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AuthFragmentPasscodeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvFragmentName.text = "PasscodeFragment"
        binding.bToMain.setOnClickListener {
            val username = "testerDave"
            val uri = Uri.parse("main://mainFragment?user=$username")
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.scanSignInFragment, true).build()
            findNavController().navigate(uri, navOptions)
        }
    }
}
