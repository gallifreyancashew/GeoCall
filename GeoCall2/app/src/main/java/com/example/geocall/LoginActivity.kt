package com.example.geocall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class LoginActivity : AppCompatActivity() {
    private lateinit var userProfileDao: UserProfileDao
    private lateinit var userProfileDatabase: UserProfileDatabase

    private lateinit var edt_email: EditText
    private lateinit var edt_password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        userProfileDatabase = UserProfileDatabase.getDatabase(application)
        userProfileDao = userProfileDatabase.userProfileDao()

        edt_email = findViewById(R.id.login_edt_email)
        edt_password = findViewById(R.id.login_edt_password)

        val newUser = findViewById<Button>(R.id.btn_signup)
        newUser.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }

        val btn_login = findViewById<Button>(R.id.login_btn_login)
        btn_login.setOnClickListener{
            val email = this.edt_email.text.toString().trim()
            val password = this.edt_password.text.toString().trim()
            val userProfile = userProfileDao.getUserProfile(email, password)

            if (userProfile != null) {
                val intent = Intent(this, HomePage::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Invalid username or password",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}