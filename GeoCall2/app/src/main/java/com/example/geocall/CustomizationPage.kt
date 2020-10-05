package com.example.geocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CustomizationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customization_page)

        val ready = findViewById<Button>(R.id.btn_ready)
        ready.setOnClickListener{
            val intent = Intent(this, WelcomePages::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }
    }
}