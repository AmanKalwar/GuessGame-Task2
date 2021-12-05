package com.example.guessgameandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberInputView = findViewById<TextInputLayout>(R.id.numberBox)
        val clickButtonView = findViewById<TextView>(R.id.clickButton)
        val resultDisplayView = findViewById<TextView>(R.id.resultView)
        var randomNumber = Random.nextInt(1, 1000)

        var count= 12

        clickButtonView.setOnClickListener {

            val num: Int = numberInputView.editText?.text.toString().toInt()


            try {
                numberInputView.editText?.text?.clear()
                if (num in 1..1000) {
                    if (num > randomNumber) {
                        count--
                        resultDisplayView.text = "No :) My number is smaller"
                        if(count==0){
                            val newScreenIntent = Intent(this, EndGameActivityLoose::class.java)
                            newScreenIntent.putExtra("guessedCorrectNumber", randomNumber)
                            startActivity(newScreenIntent)
                        }
                    } else if (num < randomNumber) {
                        count--
                        resultDisplayView.text = "No :) My number is bigger"
                        if(count==0){
                            val newScreenIntent = Intent(this, EndGameActivityLoose::class.java)
                            newScreenIntent.putExtra("guessedCorrectNumber", randomNumber)
                            startActivity(newScreenIntent)
                        }

                    } else {
                        val newScreenIntent = Intent(this, EndGameActivity::class.java)
                        newScreenIntent.putExtra("guessedCorrectNumber", randomNumber)
                        startActivity(newScreenIntent)
                        //resultDisplayView.text= "You are right!"
                    }
                } else {
                    resultDisplayView.text = "Please guess between 1 and 1000"
                }

            } catch (e: Exception) {
                resultDisplayView.text = "Enter your guessed number"
            }
        }
    }

}


