package com.example.zz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvName = findViewById<TextView>(R.id.tvUsername)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val btnNext = findViewById<Button>(R.id.button)


        val name = intent.getStringExtra("USER_NAME")
        val email = intent.getStringExtra("USER_EMAIL")

        tvName.text = name ?: "Guest User"
        tvEmail.text = email ?: "No email"


        btnNext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)


            intent.putExtra("USER_NAME", name)
            intent.putExtra("USER_EMAIL", email)

            startActivity(intent)
        }
    }
}


