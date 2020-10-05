package com.example.geocall

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.motion.widget.Debug

class MainActivity : AppCompatActivity(){
//todo: implement a swipe left thing to move on to the login page using the GestureDetector.OnGestureListener thing
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<LinearLayout>(R.id.layout_main)
        layout.setOnTouchListener{v: View, m: MotionEvent ->
            val intent = Intent(this, LoginActivity::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
            true
        }
    }
}