package com.example.quizapp

import com.example.quizapp.Questions
import com.example.quizapp.R

object Constants {

    fun getQuestions():ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()
        val que1 = Questions(
            1, "What Company does this logo belong to?", R.drawable.ic_logo1,
            "Mc-Donald's", "Mc-Kinsey", "Microsoft", "Morgan Stanley",
            1
        )
        questionsList.add(que1)
        val que2 = Questions(
            2, "What Company does this logo belong to?", R.drawable.ic_logo2,
            "Google", "Groww", "Geeks For Geeks", "Gabriel",
            3
        )
        questionsList.add(que2)
        val que3 = Questions(
            3, "What Company does this logo belong to?", R.drawable.ic_logo3,
            "Messenger", "Whatsapp", "We Chat", "Telegram",
            1
        )
        questionsList.add(que3)
        val que4 = Questions(
            4, "What Company does this logo belong to?", R.drawable.ic_logo4,
            "Viber", "Line", "IMO", "Discord",
            1
        )
        questionsList.add(que4)
        val que5 = Questions(
            5, "What Company does this logo belong to?", R.drawable.ic_logo5,
            "Unifiers", "Union Bank", "Udemy", "Unilever",
            3
        )
        questionsList.add(que5)
        return questionsList
    }

}