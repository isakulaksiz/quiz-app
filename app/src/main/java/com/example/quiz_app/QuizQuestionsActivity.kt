package com.example.quiz_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.quiz_app.databinding.ActivityMainBinding
import com.example.quiz_app.databinding.ActivityQuizQuestionsBinding
import com.example.quiz_app.model.Questions

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val questionsList   = Constants.getQuestions()
        Log.i("Soru adeti ","${questionsList.size}")

        val currentPosition = 1
        val question: Questions? = questionsList[currentPosition -1] // arrayList'in 0. indis değerinde ki  değeri

        binding.progressBar.progress = currentPosition
        binding.tvProgress.text = "$currentPosition" + "/" + binding.progressBar.max

        binding.tvQuestionId.text = question!!.question
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }
}