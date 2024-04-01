package com.lucian.historyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class MainActivity :  AppCompatActivity() {
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var ageInput: EditText
    private lateinit var clearButton: Button
    private lateinit var factTextView: TextView

    @android.annotation.SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageEditText)
        resultTextView = findViewById(R.id.resultTextView)
        factTextView = findViewById(R.id.factTextView)


//making the search button clickable
        //using if statement for ages and names

        searchButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()

            if (age != null && age in 20..100) {
                val employeeName = when (age) {
                    76 -> "Albert Einstien"
                    67 -> "Leonardo DaVinci"
                    52 -> "William Shakespeare"
                    84 -> "Isaac Newton"
                    66 -> "Marie Curie"
                    95 -> "Nelson Mandela."
                    56 -> "Abraham Lincoln"
                    68 -> "George Washington"
                    57 -> "Adolf Hitler"
                    39 -> "Martin Luther King Jr."
                    else -> null
                }


                val message = if (employeeName != null) "You share the same age as $employeeName."
                else "No famous historical person shares the same age as you."
                resultTextView.text = message

            } else {
                resultTextView.text = "Invalid input. Please enter a valid age between 20 and 100."
            }

            if (age != null && age in 20..100) {
                val employeeFact = when (age) {
                    76 -> "Albert Einstien urged the US to build an atomic bomb."
                    67 -> "Leonardo DaVinci did not attend any form of school and often wrote in reverse."
                    52 -> "William Shakespeare could not spell, got married young and wanted to be an actor at first."
                    84 -> "Isaac Newton discovered gravity as well as the 3 laws of motion"
                    66 -> "Marie Curie was the first woman to be awarded a place in the Pantheon for her achievements."
                    95 -> "Nelson Mandela won the Nobel Prize for peace in 1993 followed by a new democracy for South Africa in 1994."
                    68 -> "George Washington led an attack that started a world war."
                    56 -> "Adolf Hitler's success owed a great deal to the weakness of democracy in Germany."
                    39 -> "Martin Luther King Jr. was a prominent leader in the Civil Rights movement."
                    57 -> "Abraham Lincoln was the 16th president of the United States from 1861 until his assassination in 1865."
                    else -> null
                }

                val message1 = if (employeeFact != null) "$employeeFact"
                else ""
                factTextView.text = message1

            }

            clearButton.setOnClickListener {
                ageInput.text.clear()
                resultTextView.text = ""
                factTextView.text = ""
            }
        }
    }
}

