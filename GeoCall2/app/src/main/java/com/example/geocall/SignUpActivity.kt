package com.example.geocall

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var userProfileDao: UserProfileDao

    private lateinit var edt_email: EditText
    private lateinit var edt_password: EditText
    private lateinit var edt_fullName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        userProfileDao = UserProfileDatabase.getDatabase(application).userProfileDao()

        edt_email = findViewById(R.id.signup_edt_email)
        edt_password = findViewById(R.id.signup_edt_password)
        edt_fullName = findViewById(R.id.signup_edt_fullname)

        val btn_continue = findViewById<Button>(R.id.signup_btn_continue)
        btn_continue.setOnClickListener{
            val email = this.edt_email.text.toString().trim()
            val password = this.edt_password.text.toString().trim()
            val fullName = this.edt_fullName.text.toString().trim()
            val userProfile = UserProfile(email, password, fullName)
            userProfileDao.insert(userProfile)

            val intent = Intent(this, PhonePage::class.java)
            startActivity(intent)
        }

        val btn_hasAccount = findViewById<Button>(R.id.btn_hasAccount)
        btn_hasAccount.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            //val msg = intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }
    }

}