package com.example.calcul_imc

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlin.math.round
import kotlin.math.sqrt
import kotlin.math.truncate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val maleButton = findViewById<ImageView>(R.id.ic_male)
        val femaleButton = findViewById<ImageView>(R.id.ic_female)
        val slider = findViewById<Slider>(R.id.slider)
        val textSlider = findViewById<TextView>(R.id.numSlider)
        val numWeight = findViewById<TextView>(R.id.numWeight)
        val weightPlus = findViewById<ImageView>(R.id.weightPlus)
        val weightMinus = findViewById<ImageView>(R.id.weightMinus)
        val numAge = findViewById<TextView>(R.id.numAge)
        val agePlus = findViewById<ImageView>(R.id.agePlus)
        val ageMinus = findViewById<ImageView>(R.id.ageMinus)
        val calculateButton = findViewById<LinearLayout>(R.id.btnCalculate)

        slider.addOnChangeListener { slider, value, fromUser -> textSlider.text = value.toString() }

        weightPlus.setOnClickListener {
            if (numWeight.text.toString().toInt() >= 25 && numWeight.text.toString().toInt() < 200) {
                var num = numWeight.text.toString().toInt()
                numWeight.text = (num + 1).toString()
            }
        }

        weightMinus.setOnClickListener {
            if (numWeight.text.toString().toInt() > 25 && numWeight.text.toString().toInt() <= 200) {
                var num = numWeight.text.toString().toInt()
                numWeight.text = (num - 1).toString()
            }
        }

        agePlus.setOnClickListener {
            if (numAge.text.toString().toInt() >= 14 && numAge.text.toString().toInt() < 100) {
                var num = numAge.text.toString().toInt()
                numAge.text = (num + 1).toString()
            }
        }

        ageMinus.setOnClickListener {
            if (numAge.text.toString().toInt() > 14 && numAge.text.toString().toInt() <= 100) {
                var num = numAge.text.toString().toInt()
                numAge.text = (num - 1).toString()
            }
        }

        calculateButton.setOnClickListener {
            val peso = numWeight.text.toString().toDouble()
            val altura = textSlider.text.toString().toDouble() / 100
            val numIMC = round((peso / (altura * altura)) * 100) / 100
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("numIMC", numIMC.toString())
            startActivity(intent)
        }
    }
}