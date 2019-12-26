package nl.mohinder.quizmaker

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    var question: String = ""
    var answer: String = ""

    fun isCorrectAnswer(answer: String): Boolean {
        return this.answer.toLowerCase() === answer.toLowerCase()
    }

    fun createQuestion(question: String, answer: String) {
        this.question = question
        this.answer = answer
    }

    fun isQuestionCreated(): Boolean {
        return this.question.isNotBlank() && this.answer.isNotBlank()
    }

}