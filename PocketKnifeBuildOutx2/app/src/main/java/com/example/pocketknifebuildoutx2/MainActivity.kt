package com.example.pocketknifebuildoutx2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import isItRooted

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var toast: Toast
        lateinit var textMessage: TextView
        lateinit var button: Button
        lateinit var crash_button: Button

        val builder = StringBuilder()
        val properties: Map<String, String> = HashMap()
        // Setup buttons
        button = findViewById(R.id.button_Map_id)
        button.setText(R.string.title_map_button)

        crash_button = findViewById(R.id.button_crash_id)
        crash_button.setText(R.string.button_crash_text)

        textMessage = findViewById(R.id.message)
        textMessage.setTextColor(Color.BLACK)



        textMessage.setText(isItRooted(this, builder))
    }
}