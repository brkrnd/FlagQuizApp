package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,"What country does this flag belong to?",R.drawable.china_flag,
            "Turkey", "China", "Japan", "Vietnam",
            2
        )

        val question2 = Question(
            1,"What country does this flag belong to?",R.drawable.germany_flag,
            "Spain", "Taiwan", "Austria", "Germany",
            4
        )

        val question3 = Question(
            1,"What country does this flag belong to?",R.drawable.greatbritain_flag,
            "India", "Ireland", "Fiji", "Great Britain",
            4
        )

        val question4 = Question(
            1,"What country does this flag belong to?",R.drawable.india_flag,
            "India", "Pakistan", "Bangladesh", "Kuwait",
            1
        )

        val question5 = Question(
            1,"What country does this flag belong to?",R.drawable.puertorico_flag,
            "Fiji", "Jamaica", "Puerto Rico", "Liberia",
            3
        )

        val question6 = Question(
            1,"What country does this flag belong to?",R.drawable.russia_flag,
            "Russia", "Canada", "Germany", "Ukraine",
            1
        )

        val question7 = Question(
            1,"What country does this flag belong to?",R.drawable.southkorea_flag,
            "Japan", "South Korea", "Bangladesh", "Portugal",
            2
        )

        val question8 = Question(
            1,"What country does this flag belong to?",R.drawable.spain_flag,
            "Italy", "Greece", "Austria", "Spain",
            4
        )

        val question9 = Question(
            1,"What country does this flag belong to?",R.drawable.unitedarabemirates_flag,
            "Jordan", "United Arab Emirates", "China", "Kuwait",
            2
        )

        val question10 = Question(
            1,"What country does this flag belong to?",R.drawable.usa_flag,
            "Canada", "Malaysia", "Mexico", "United States of America",
            4
        )

        val question11 = Question(
            1,"What country does this flag belong to?",R.drawable.uzbekistan_flag,
            "China", "Turkey", "Kazakhstan", "Uzbekistan",
            4
        )

        val question12 = Question(
            1,"What country does this flag belong to?",R.drawable.vietnam_flag,
            "North Korea", "Sweden", "Jamaica", "Vietnam",
            4
        )

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)
        questionList.add(question9)
        questionList.add(question10)
        questionList.add(question11)
        questionList.add(question12)

        return questionList
    }

}