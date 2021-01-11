package com.example.pocketknifebuildoutx1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.example.library_isitrooted.isItRooted


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    lateinit var toast: Toast
    lateinit var textMessage: TextView
    lateinit var button: Button
    lateinit var crash_button: Button

    val builder = StringBuilder()
    val properties: Map<String, String> = HashMap()

}