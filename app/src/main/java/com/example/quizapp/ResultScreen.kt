package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultScreen : AppCompatActivity() {

    private var usernameAtResultScreen : TextView ?= null
    private var finishButton : Button ?= null
    private var scoreTextView : TextView ?= null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        //usernameAtResultScreen = findViewById(R.id.usernameAtResultScreen)
        scoreTextView = findViewById(R.id.scoreTextView)
        finishButton = findViewById(R.id.finishButton)

        //usernameAtResultScreen?.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 12)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        scoreTextView?.text = "Your score is $correctAnswers out of $totalQuestions"

        finishButton?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}