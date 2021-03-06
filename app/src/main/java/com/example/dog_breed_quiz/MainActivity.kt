package com.example.dog_breed_quiz

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var correctCount = 0
    var totalCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting the TextViews
        val question = findViewById<TextView>(R.id.ques)
        val answer = findViewById<TextView>(R.id.ans)

        //Getting the ImageButtons
        val imgBtn1 = findViewById<ImageButton>(R.id.imageButton)
        val imgBtn2 = findViewById<ImageButton>(R.id.imageButton2)
        val imgBtn3 = findViewById<ImageButton>(R.id.imageButton3)

        //Getting the buttons
        val finishBtn = findViewById<Button>(R.id.finishbtn)
        val nextBtn = findViewById<Button>(R.id.nxtBtn)

        //Creating new objects for the class Breed
        val carin = Breed("Carin")
        val eskimo = Breed("Eskimo dog")
        val german = Breed("German shepard")

        //Adding images to the each breed

        carin.images.add("img10")
        carin.images.add("img11")
        carin.images.add("img12")

        eskimo.images.add("img20")
        eskimo.images.add("img21")
        eskimo.images.add("img22")

        german.images.add("img30")
        german.images.add("img31")
        german.images.add("img32")

        //Storing Breed objects
        val breeds = mutableListOf<Breed>(carin, eskimo, german)

        // Setting the images
        setImage(imgBtn1, imgBtn2, imgBtn3, breeds, question, answer)

        nextBtn.setOnClickListener {
            setImage(imgBtn1, imgBtn2, imgBtn3, breeds, question, answer)
        }
        finishBtn.setOnClickListener {
            finishing()
        }

    }

    fun finishing(){
        val scorer = Intent(this, Score_Viewer::class.java)
        scorer.putExtra("correct", correctCount.toString())
        scorer.putExtra("total", totalCount.toString())
        startActivity(scorer)
    }

    fun setImage(imgBtn1: ImageButton, imgBtn2: ImageButton, imgBtn3: ImageButton, breeds: List<Breed>, question: TextView, answer: TextView) {

        if(breeds[0].images.size != 0) {

            imgBtn1.isEnabled = true
            imgBtn2.isEnabled = true
            imgBtn3.isEnabled = true

            totalCount++

            //Initializing the textViews
            question.text = " "
            answer.text = " "

            //Shuffling the breeds list for the randomizing purpose
            Collections.shuffle(breeds)

            //Assigning the breeds
            val img1 = breeds[0]
            val img2 = breeds[1]
            val img3 = breeds[2]

            //Setting the image resources

            val id1 =
                resources.getIdentifier(img1.images[0], "drawable", "com.example.dog_breed_quiz")
            val id2 =
                resources.getIdentifier(img2.images[0], "drawable", "com.example.dog_breed_quiz")
            val id3 =
                resources.getIdentifier(img3.images[0], "drawable", "com.example.dog_breed_quiz")

            imgBtn1.setImageResource(id1)
            imgBtn2.setImageResource(id2)
            imgBtn3.setImageResource(id3)

            //Generating a random number
            val gen = Random()
            val index = gen.nextInt(3)

            //Setting the question
            question.text = "Select " + breeds[index].name

            //Setting the action listeners

            imgBtn1.setOnClickListener() {
                imgBtn2.isEnabled = false
                imgBtn3.isEnabled = false
                if (img1.name == breeds[index].name) {
                    answer.text = "Correct"
                    answer.setTextColor(Color.parseColor("green"));
                    correctCount++
                } else {
                    answer.text = "Incorrect"
                    answer.setTextColor(Color.parseColor("red"));
                }
            }
            imgBtn2.setOnClickListener() {
                imgBtn1.isEnabled = false
                imgBtn3.isEnabled = false
                if (img2.name == breeds[index].name) {
                    answer.text = "Correct"
                    answer.setTextColor(Color.parseColor("green"));
                    correctCount ++
                } else {
                    answer.text = "Incorrect"
                    answer.setTextColor(Color.parseColor("red"));
                }
            }
            imgBtn3.setOnClickListener() {
                imgBtn1.isEnabled = false
                imgBtn2.isEnabled = false
                if (img3.name == breeds[index].name) {
                    answer.text = "Correct"
                    answer.setTextColor(Color.parseColor("green"));
                    correctCount ++
                } else {
                    answer.text = "Incorrect"
                    answer.setTextColor(Color.parseColor("red"));
                }
            }

            // Removing the each already assigned images for the purpose of image uniqueness.
            img1.images.removeAt(0)
            img2.images.removeAt(0)
            img3.images.removeAt(0)

        } else {
            Toast.makeText(applicationContext, "Number of questions are finished...", Toast.LENGTH_LONG).show()
            finishing()
        }
    }
}