package com.example.quizapp

data class Question(

    val questionID : Int,
    val questionText : String,
    val image : Int,

    val optionOne : String,
    val optionTwo : String,
    val optionThree : String,
    val optionFour : String,

    val correctAnswer : Int
)
