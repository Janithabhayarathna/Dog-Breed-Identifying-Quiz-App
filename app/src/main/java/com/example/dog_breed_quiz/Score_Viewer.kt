package com.example.dog_breed_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Score_Viewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_viewer)

        val result = findViewById<TextView>(R.id.textView)

        val correctAnswers = intent.getStringExtra("correct")
        val tot = intent.getStringExtra("total")

        result.text = "You have scored $correctAnswers out of $tot"

    }
}