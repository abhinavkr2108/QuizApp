package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton: Button = findViewById(R.id.start)
        val etName: EditText = findViewById(R.id.etName)

        startButton.setOnClickListener{
            if (etName.text.isEmpty()){
                Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuizQuestions::class.java)
                startActivity(intent)
            }
        }
    }

}