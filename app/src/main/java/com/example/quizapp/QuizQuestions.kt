package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestions : AppCompatActivity(), View.OnClickListener {
     var questionsList: ArrayList<Questions>? = null
    private var name:String?=null
    private var score:Int = 0
    private var currentPosition: Int =1
    private var selectedOption: Int =0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        name= intent.getStringExtra(Constants.name)
        setContentView(R.layout.activity_quiz_questions)
        Constants.getQuestions()
        questionsList = Constants.getQuestions()
        setQuestion()

        option1.setOnClickListener{
            selectedOption(option1, 1)
        }

        option2.setOnClickListener{
            selectedOption(option2, 2)
        }

        option3.setOnClickListener{
            selectedOption(option3, 3)
        }

        option4.setOnClickListener{
            selectedOption(option4, 4)
        }

        Submit.setOnClickListener {
            if (selectedOption!=0){
                val question = questionsList!![currentPosition-1]
                if (selectedOption!= question.correctAnswer){
                    setColor(selectedOption, R.drawable.wrong_answer)
                }
                else{
                    score++
                }
                setColor(question.correctAnswer, R.drawable.correct_answer)

                if (currentPosition==questionsList!!.size){
                    Submit.text= "FINISH"
                }
                else{
                    Submit.text= "NEXT"
                }
            }
            else{
                currentPosition++
                when {
                    currentPosition<= questionsList!!.size->{
                        setQuestion()
                    }
                else->{
                    var  intent = Intent(this, Result::class.java )
                    intent.putExtra("${Constants.name}", name.toString())
                    intent.putExtra("${Constants.score}", score.toString())
                    intent.putExtra("Total Size", questionsList!!.size.toString())
                    startActivity(intent)
                    finish()
                }
                }

            }
            selectedOption=0
        }

    }

    fun setColor(option: Int, color: Int) {
        when (option){
            1-> {
                option1.background= ContextCompat.getDrawable(this, color)
            }
            2-> {
                option2.background= ContextCompat.getDrawable(this, color)
            }
            3-> {
                option3.background= ContextCompat.getDrawable(this, color)
            }
            4-> {
                option4.background= ContextCompat.getDrawable(this, color)
            }
        }
    }
    private fun setQuestion() {

        defaultOptionView()
        Log.i("QuestionList Size: ", "${questionsList!!.size}")

        for (i in questionsList!!) {
            Log.e("Questions", i.questions)
        }

        val question: Questions = questionsList!![currentPosition - 1]
        progressBar.progress = currentPosition
        progressBar.max= questionsList!!.size
        tvProgress.text = "${currentPosition}/${progressBar.max}"
        tvQuestion.text = question.questions
        tvImage?.setImageResource(question.image)

        option1.text = question.optionOne
        option2.text = question.optionTwo
        option3.text = question.optionThree
        option4.text = question.optionFour
    }

    private fun defaultOptionView(){
        val optionsList = ArrayList<TextView>()
        optionsList.add(0,option1)
        optionsList.add(1,option2)
        optionsList.add(2,option3)
        optionsList.add(3,option4)

        for (op in optionsList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background= ContextCompat.getDrawable(this, R.drawable.border_bg)
        }
    }

    fun selectedOption(view: TextView,option:Int){
        defaultOptionView()
        selectedOption = option
        view.background= ContextCompat.getDrawable(this, R.drawable.selected_button_border)
        view.typeface = Typeface.DEFAULT_BOLD
    }
    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}