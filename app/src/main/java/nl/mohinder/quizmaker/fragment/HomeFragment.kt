package nl.mohinder.quizmaker.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import nl.mohinder.quizmaker.QuizViewModel

import nl.mohinder.quizmaker.R

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(activity as AppCompatActivity).get(QuizViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnCreateQuestion.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createQuizFragment)
        }
        btnStartQuiz.setOnClickListener {
            if (viewModel.isQuestionCreated()) {
                findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
            } else {
                Toast.makeText(context, "Create a question first!", Toast.LENGTH_LONG).show()
            }
        }
    }


}
