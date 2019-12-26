package nl.mohinder.quizmaker.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_quiz.*
import nl.mohinder.quizmaker.QuizViewModel

import nl.mohinder.quizmaker.R

/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {

    private lateinit var viewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(activity as AppCompatActivity).get(QuizViewModel::class.java)
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvQuestion.text = viewModel.question

        btnConfirmAnswer.setOnClickListener {
            if (viewModel.isCorrectAnswer(etAnswer.text.toString())) {
                Toast.makeText(context, "Your answer is good!", Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            } else {
                Toast
                    .makeText(
                        context,
                        "Your answer is bad. The correct answer was ${viewModel.answer}",
                        Toast.LENGTH_LONG)
                    .show()
            }
        }
    }


}
