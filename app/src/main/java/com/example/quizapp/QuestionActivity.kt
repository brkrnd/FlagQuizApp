package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionsList:ArrayList<Question> ?= null
    private var mSelectedOptionsPosition : Int = 0
    private var mUserName : String ?= null
    private var mCorrectAnswers : Int = 0

    private var flagImageView : ImageView ?= null
    private var progressBar : ProgressBar ?= null
    private var questionTextView : TextView ?= null
    private var progressBarTextView : TextView ?= null

    private var optionOneText : TextView ?= null
    private var optionTwoText : TextView ?= null
    private var optionThreeText : TextView ?= null
    private var optionFourText : TextView ?= null
    private var submitButton : Button ?= null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        questionTextView = findViewById(R.id.questionTextView)
        flagImageView = findViewById(R.id.flagImageView)
        progressBar = findViewById(R.id.progressBar)
        progressBarTextView = findViewById(R.id.progressBarTextView)
        optionOneText = findViewById(R.id.optionOneText1)
        optionTwoText = findViewById(R.id.optionTwoText1)
        optionThreeText = findViewById(R.id.optionThreeText1)
        optionFourText = findViewById(R.id.optionFourText1)
        submitButton = findViewById(R.id.submitButton)

        optionOneText?.setOnClickListener(this)
        optionTwoText?.setOnClickListener(this)
        optionThreeText?.setOnClickListener(this)
        optionFourText?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

    }

    @SuppressLint("SetTextI18n")
    fun setQuestion(){

        defaultOptionsView()
        val question : Question = mQuestionsList!![mCurrentPosition - 1]
        flagImageView?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        progressBarTextView?.text = "$mCurrentPosition/${progressBar?.max}"
        questionTextView?.text = question.questionText
        optionOneText?.text = question.optionOne
        optionTwoText?.text = question.optionTwo
        optionThreeText?.text = question.optionThree
        optionFourText?.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size){
            submitButton?.text = "FINISH"
        } else {
            submitButton?.text = "SUBMIT"
        }

    }

    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()
        optionOneText?.let {
            options.add(0,it)
        }
        optionTwoText?.let {
            options.add(1,it)
        }
        optionThreeText?.let {
            options.add(2,it)
        }
        optionFourText?.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#111111"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
            R.drawable.option_border)
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNumber : Int){

        defaultOptionsView()

        mSelectedOptionsPosition = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#111111"))
        textView.setTypeface(textView.typeface,Typeface.BOLD_ITALIC)
        textView.background = ContextCompat.getDrawable(this,
            R.drawable.selected_option_border)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOneText1 -> {
                optionOneText?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.optionTwoText1 -> {
                optionTwoText?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.optionThreeText1 -> {
                optionThreeText?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.optionFourText1 -> {
                optionFourText?.let {
                    selectedOptionView(it,4)
                }
            }
            R.id.submitButton -> {
                if(mSelectedOptionsPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        } else ->{
                            val intent = Intent(this, ResultScreen::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size.toString())
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionsPosition){
                        answerView(mSelectedOptionsPosition,R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        submitButton?.text = "FINISH"
                    } else {
                        submitButton?.text = "NEXT QUESTION"
                    }
                    mSelectedOptionsPosition = 0
                }
            }
        }
    }
    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                optionOneText?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                optionTwoText?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                optionThreeText?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                optionFourText?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}

