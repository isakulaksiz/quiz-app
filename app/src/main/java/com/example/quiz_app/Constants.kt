package com.example.quiz_app

import com.example.quiz_app.model.Questions

object Constants{
    fun getQuestions(): ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val question1 = Questions(1,
            "Bu bayrak hangi ülkeye ait?",
            R.drawable.ic_flag_of_brazil, "Arjantin", "Avusturalya", "Danimarka", "Brezilya", 4)
        questionsList.add(question1)

        val question2 = Questions(1,
            "Bu bayrak hangi ülkeye ait?",
            R.drawable.ic_flag_of_argentina, "Arjantin", "Avusturalya", "Danimarka", "Brezilya", 1)
        questionsList.add(question2)

        val question3 = Questions(1,
            "Bu bayrak hangi ülkeye ait?",
            R.drawable.ic_flag_of_belgium, "Arjantin", "Avusturalya", "Türkiye", "Belçika", 4)
        questionsList.add(question3)

        val question4 = Questions(1,
            "Bu bayrak hangi ülkeye ait?",
            R.drawable.ic_flag_of_germany, "Almanya", "Avusturalya", "Danimarka", "Brezilya", 1)
        questionsList.add(question4)

        val question5 = Questions(1,
            "Bu bayrak hangi ülkeye ait?",
            R.drawable.ic_flag_of_india, "Arjantin", "Hindistan", "Danimarka", "Brezilya", 4)
        questionsList.add(question5)

        return questionsList
    }
}