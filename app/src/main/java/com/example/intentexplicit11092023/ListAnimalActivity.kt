package com.example.intentexplicit11092023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ListAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        if (intent != null) {
            val text = intent.getStringExtra("text")
            val number = intent.getIntExtra("number", -1)

            Log.d("pphat", "Text: $text")
            Log.d("pphat", "Number: $number")
        }
    }
}