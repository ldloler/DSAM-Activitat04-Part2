package com.example.calcul_imc

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider

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

        slider.addOnChangeListener { slider, value, fromUser -> textSlider.text = value.toString() }
    }
}