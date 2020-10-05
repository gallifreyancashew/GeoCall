package com.example.geocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val cont = findViewById<Button>(R.id.btn_phonepage_continue)
        cont.setOnClickListener{
            val intent = Intent(this, PhonePage::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }

        val hasAccount = findViewById<Button>(R.id.btn_hasAccount)
        hasAccount.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }
    }

}