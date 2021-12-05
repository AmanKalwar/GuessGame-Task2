package com.example.guessgameandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EndGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        val correctNumber = intent.getIntExtra("guessedCorrectNumber",0)
        findViewById<TextView>(R.id.wrongNumberView).text = "$correctNumber"
    }
}