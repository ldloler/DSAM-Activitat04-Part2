package com.example.calcul_imc

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val textCalculIMC = findViewById<TextView>(R.id.textCalculIMC)
        val numCalculIMC = findViewById<TextView>(R.id.numCalculIMC)
        val botoEnrere = findViewById<ImageView>(R.id.goBack)
        val recalculate = findViewById<LinearLayout>(R.id.btReCalculate)

        val numIMC = intent.getStringExtra("numIMC").toString().toDouble()

        numCalculIMC.text = numIMC.toString()

        val tipoPes = when {
            numIMC < 18.5 -> "Insufficient weight"
            numIMC in 18.5..24.9 -> "Normal"
            numIMC in 25.0..29.9 -> "Overweight"
            numIMC >= 30 -> "Obesity"
            else -> "Error"
        }

        textCalculIMC.text = tipoPes

        when (tipoPes) {
            "Insufficient weight" -> textCalculIMC.setTextColor(Color.RED)
            "Normal" -> textCalculIMC.setTextColor(Color.GREEN)
            "Overweight" -> textCalculIMC.setTextColor(Color.YELLOW)
            "Obesity" -> textCalculIMC.setTextColor(Color.RED)
        }

        botoEnrere.setOnClickListener {
            finish()
        }

        recalculate.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}