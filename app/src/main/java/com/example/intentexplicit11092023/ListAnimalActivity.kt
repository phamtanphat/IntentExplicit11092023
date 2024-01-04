package com.example.intentexplicit11092023

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ListAnimalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_animal)

        if (intent != null) {
            val arrAnimals = intent.getStringArrayExtra("array_animals")
            Log.d("pphat", arrAnimals?.size.toString())
        }
    }

    private fun getDataIntent() {
        val text = intent.getStringExtra("text")
        val number = intent.getIntExtra("number", -1)
        val arrayString = intent.getStringArrayExtra("array_string")
        val arrayListString = intent.getStringArrayListExtra("array_list_string")
//            val person: Person = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                intent.getSerializableExtra("object", Person("").javaClass) as Person
//            } else {
//                intent.getSerializableExtra("object") as Person
//            }
//
//            val listPerson: ArrayList<Person> = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                intent.getSerializableExtra("list_object", arrayListOf(Person("")).javaClass) as ArrayList<Person>
//            } else {
//                intent.getSerializableExtra("list_object") as ArrayList<Person>
//            }

        val person: Person? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("object", Person::class.java)
        } else {
            intent.getParcelableExtra("object")
        }

        val listPerson: ArrayList<Person>? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("list_object", Person::class.java)
        } else {
            intent.getParcelableArrayListExtra("list_object")
        }

        val bundleFromIntent = intent.getBundleExtra("bundle")
        val textFromBundle = bundleFromIntent?.getString("text_bundle")

        Log.d("pphat", "Text: $text")
        Log.d("pphat", "Number: $number")
        Log.d("pphat", "Array String: ${arrayString?.get(0)}")
        Log.d("pphat", "Array List String: ${arrayListString?.get(0)}")
        Log.d("pphat", "Object: ${person?.name}")
        Log.d("pphat", "ArrayList Object: ${listPerson?.size}")
        Log.d("pphat", "Bundle: $textFromBundle")
    }
}