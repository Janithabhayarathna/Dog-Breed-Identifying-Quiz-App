package com.example.dog_breed_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    val gen = Random()

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

        val carin = Breed("Carin")
        val eskimo = Breed("Eskimo dog")
        val german = Breed("German shepard")

        val breeds = mutableListOf<Breed>(carin, eskimo, german)

        carin.images.add("img10")
        carin.images.add("img11")
        carin.images.add("img12")

        eskimo.images.add("img20")
        eskimo.images.add("img21")
        eskimo.images.add("img22")

        german.images.add("img30")
        german.images.add("img31")
        german.images.add("img32")

        setImage(imgBtn1, imgBtn2, imgBtn3, breeds, question, answer)

        nextBtn.setOnClickListener {
            setImage(imgBtn1, imgBtn2, imgBtn3, breeds, question, answer)
        }
        finishBtn.setOnClickListener {

        }

    }

    fun setImage(imgBtn1: ImageButton, imgBtn2: ImageButton, imgBtn3: ImageButton, breeds: List<Breed>, question: TextView, answer: TextView) {

        question.text = " "
        answer.text = " "

        val index = gen.nextInt(breeds.size)

        Collections.shuffle(breeds)

        val img1 = breeds[0]
        val img2 = breeds[0]
        val img3 = breeds[0]

        val id1 = resources.getIdentifier(img1.images[0], "drawable", "com.example.dog_breed_quiz")
        val id2 = resources.getIdentifier(img2.images[0], "drawable", "com.example.dog_breed_quiz")
        val id3 = resources.getIdentifier(img3.images[0], "drawable", "com.example.dog_breed_quiz")

        imgBtn1.setImageResource(id1)
        imgBtn2.setImageResource(id2)
        imgBtn3.setImageResource(id3)
    }
}