import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.ui.binding.FragmentBinding

class InstructionsFragment : Fragment(R.layout.fragment_instructions) {

    private val binding by FragmentBinding(FragmentInstructionsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}