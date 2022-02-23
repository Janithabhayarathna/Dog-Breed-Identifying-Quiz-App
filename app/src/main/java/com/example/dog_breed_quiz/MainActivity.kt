package com.example.dog_breed_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val question = findViewById<TextView>(R.id.ques)
        val answer = findViewById<TextView>(R.id.ans)

        val imgBtn1 = findViewById<ImageButton>(R.id.imageButton)
        val imgBtn2 = findViewById<ImageButton>(R.id.imageButton3)
        val imgBtn3 = findViewById<ImageButton>(R.id.imageButton2)

        val nextBtn = findViewById<Button>(R.id.nxtbtn)
        val finishBtn = findViewById<Button>(R.id.finishBtn)

        

    }
}