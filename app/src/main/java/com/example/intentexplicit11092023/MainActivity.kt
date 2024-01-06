package com.example.intentexplicit11092023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var imgRandom: ImageView
    private lateinit var imgUserSelect: ImageView
    private lateinit var tvScore: TextView
    private var drawableRandom: Int = 0
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
            intent.putExtra("array_animals", arrAnimals)
            activityResultLauncher.launch(intent)
        }
    }

    private val activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK && result.data != null) {
            val drawableUserSelect = result.data?.getIntExtra("drawable", -1) ?: return@registerForActivityResult
            if (drawableUserSelect != -1) {
                imgUserSelect.setImageResource(drawableUserSelect)
            }

            if (drawableUserSelect == drawableRandom) {
                Toast.makeText(this@MainActivity, "Chinh xac", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    makeImageRandom(imgRandom, arrAnimals)
                }, 1000)
            } else {
                Toast.makeText(this@MainActivity, "Sai roi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun makeImageRandom(imageView: ImageView, arrayName: Array<String>) {
        val index = Random.nextInt(arrayName.size)
        val nameDrawable = arrayName[index]
        drawableRandom = DrawableUtil.getImageResource(nameDrawable, this)
        imageView.setImageResource(drawableRandom)
    }

    private fun initView() {
        imgRandom = findViewById(R.id.image_view_random)
        imgUserSelect = findViewById(R.id.image_view_user_select)
        tvScore = findViewById(R.id.text_view_score)
    }

    private fun sendDataIntent() {
        val intent = Intent(this@MainActivity, ListAnimalActivity::class.java)
        intent.putExtra("text", "Hello")
        intent.putExtra("number", 10)
        intent.putExtra("array_string", arrayOf("Ti"))
        intent.putExtra("array_list_string", arrayListOf("Teo", "Ti"))
        intent.putExtra("object",  Person("abc"))
        intent.putParcelableArrayListExtra("list_object", arrayListOf(Person("teo"), Person("ti")))

        val bundle = Bundle()
        bundle.putString("text_bundle", "Data from Bundle")
        intent.putExtra("bundle", bundle)
        startActivity(intent)
    }
}