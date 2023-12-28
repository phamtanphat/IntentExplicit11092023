package com.example.intentexplicit11092023

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imgRandom: ImageView
    private lateinit var imgUserSelect: ImageView
    private lateinit var tvScore: TextView
    private val arrAnimals by lazy {
        resources.getStringArray(R.array.array_animals)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        event()
        makeImageRandom(imgRandom, arrAnimals)
    }

    private fun event() {
        imgUserSelect.setOnClickListener {
            val intent = Intent(this@MainActivity, ListAnimalActivity::class.java)
            intent.putExtra("text", "Hello")
            intent.putExtra("number", 10)
            startActivity(intent)
        }
    }

    private fun makeImageRandom(imageView: ImageView, arrayName: Array<String>) {
        val index = Random.nextInt(arrayName.size)
        val nameDrawable = arrayName[index]
        val imageResource = randomImageResource(nameDrawable)
        imageView.setImageResource(imageResource)
    }

    @SuppressLint("DiscouragedApi")
    private fun randomImageResource(nameImageResource: String): Int {
        return resources.getIdentifier(nameImageResource, "drawable", packageName)
    }

    private fun initView() {
        imgRandom = findViewById(R.id.image_view_random)
        imgUserSelect = findViewById(R.id.image_view_user_select)
        tvScore = findViewById(R.id.text_view_score)
    }
}