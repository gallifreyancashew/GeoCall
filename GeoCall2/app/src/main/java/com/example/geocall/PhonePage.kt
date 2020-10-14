package com.example.geocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PhonePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_page)

        val btn_login = findViewById<Button>(R.id.phonepage_btn_login)
        btn_login.setOnClickListener{
            val intent = Intent(this, CustomizationPage::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }

        val tac = findViewById<Button>(R.id.btn_termsandconditions)
        tac.setOnClickListener{
            val intent = Intent(this, TermsAndConditions::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }
    }
}