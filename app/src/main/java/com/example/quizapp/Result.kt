package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra("${Constants.name}")
        val score = intent.getStringExtra("${Constants.score}")
        val TotalSize = intent.getStringExtra("Total Size")

        ResultText.text = "Hello ${username}, your score is"
        ScoreText.text = "${score}/${TotalSize}"

        FinishButton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java ))
            finish()
        }
    }
}