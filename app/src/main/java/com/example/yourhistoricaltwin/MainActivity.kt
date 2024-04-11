package com.example.yourhistoricaltwin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // declaring variables
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearbutton: Button
    private lateinit var searchbutton: Button


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// initialising buttons
        searchbutton = findViewById(R.id.search_button)
        clearbutton = findViewById(R.id.Clearbutton)
        ageInput = findViewById(R.id.ageInput)
        resultTextView = findViewById(R.id.resultTextView)

        //enabling buttons to be clicked on
        searchbutton.setOnClickListener {
            //create variables of age to get value from user
            val age = ageInput.text.toString().toIntOrNull()

            //since ages range are between 20 and 100
            if (age != null && age in 20..100) {
                //when age 41 displays shaka zulu when 25 displays amy whine ..etc

                val celebrityName = when (age) {
                    67 -> "Leonardo da Vinci"
                    39 -> "Cleopatra"
                    32 -> "Alexander The Great"
                    92 -> "Rosa Parks"
                    50 -> "Michael Jackson"
                    35 -> "Mozart"
                    54 -> "Christopher Columbus"
                    77 -> "Galileo Galilei"
                    78 -> "Mahatma Ghandi"
                    95 -> "Nelson Mandela"
                    48 -> "Whitney Houston"
                    else -> null

                }
                val message = if (celebrityName != null) "$celebrityName"
                else "Your value is invalid, there are no historical figure under this age"
                resultTextView.text = message


            } else {

                resultTextView.text = "Invalid ageInput"
            }
            clearbutton.setOnClickListener {
                ageInput.text.clear()
                resultTextView.text = ""
            }
        }
    }
}
