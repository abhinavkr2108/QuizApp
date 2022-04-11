package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestions : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvImage: ImageView? = null
    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvImage = findViewById(R.id.tvImage)
        tvOptionOne = findViewById(R.id.option1)
        tvOptionTwo = findViewById(R.id.option2)
        tvOptionThree = findViewById(R.id.option3)
        tvOptionFour = findViewById(R.id.option4)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        Constants.getQuestions()
        val questionsList = Constants.getQuestions()
        Log.i("QuestionList Size: ", "${questionsList.size}")

        for (i in questionsList){
            Log.e("Questions", i.questions)
        }

        var currentPosition =1
        val question : Questions = questionsList[currentPosition-1]
        progressBar?.progress = currentPosition
        tvProgress?.text = "${currentPosition}/${progressBar?.max}"
        tvQuestion?.text = question.questions
        tvImage?.setImageResource(question.image)

        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

    }
}