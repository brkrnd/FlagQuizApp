package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var startButton : Button ?= null
    private var editTextName : EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startButton)
        editTextName = findViewById(R.id.editTextName)

        startButton?.setOnClickListener{
            if (editTextName?.text?.isNotEmpty() == true) {
                intent.putExtra(Constants.USER_NAME, editTextName?.text.toString())
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
                finish()}
            else{
                Toast.makeText(this,"Please enter a name", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun openQuestionActivity(){
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }
}