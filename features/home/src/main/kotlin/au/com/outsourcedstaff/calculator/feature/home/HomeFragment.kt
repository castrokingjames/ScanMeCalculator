package au.com.outsourcedstaff.calculator.feature.home

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import au.com.outsourcedstaff.calculator.feature.home.databinding.FragmentHomeBinding
import com.airbnb.mvrx.*
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment(), MavericksView {

    @Inject
    lateinit var viewModelFactory: HomeViewModel.Factory

    private val viewModel: HomeViewModel by fragmentViewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val contract = registerForActivityResult(Contract()) { uri: Uri? ->
        if (uri != null) {
            viewModel.load(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            contract.launch(null)
        }
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            val image = state.image
            if (image is Success) {
                binding.content.container.visibility = View.VISIBLE
                binding.content.previewImageView.setImageURI(image())
                binding.empty.container.visibility = View.GONE
            } else {
                binding.content.container.visibility = View.GONE
                binding.empty.container.visibility = View.VISIBLE
            }

            val expression = state.expression
            if (expression is Success) {
                binding.content.expressionTextView.text = expression()
            } else if (expression is Fail) {
                binding.content.expressionTextView.text = expression.error.message
                binding.content.resultTextView.text = null
            }

            val result = state.result
            if (result is Success) {
                binding.content.resultTextView.text = result()
            } else if (result is Fail) {
                binding.content.resultTextView.text = result.error.message
            }
        }
    }
}