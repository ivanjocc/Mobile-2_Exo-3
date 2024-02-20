package com.example.exo2

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var temperatureTextView : TextView
    private lateinit var colorTextView : TextView
    private var temperature : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        temperatureTextView = findViewById(R.id.temperatureTextView)
        colorTextView = findViewById(R.id.colorTextView)

        val changeButton : Button = findViewById(R.id.changeTempButton)

        changeButton.setOnClickListener{
            changeTemperature()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun changeTemperature() {
//        Do it up to a maximum temperature of 30 °C
        temperature = (temperature + 5) % 35
        temperatureTextView.text = "Temperature $temperature °C"
        colorTextView.setBackgroundColor(getColorFromTemperature(temperature))
    }

    private fun getColorFromTemperature(temperature: Int): Int {
        return when {
            temperature < 10 -> Color.BLUE
            temperature < 20 -> Color.GREEN

            else -> Color.RED
        }
    }
}