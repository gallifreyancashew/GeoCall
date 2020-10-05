package com.example.geocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        val newUser = findViewById<Button>(R.id.btn_signup)
        newUser.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }

        val login = findViewById<Button>(R.id.login_button)
        login.setOnClickListener{
            val intent = Intent(this, HomePage::class.java)
            //val msg = intent.putExtra("name", name.text.toString())
            startActivity(intent)
        }
    }
}