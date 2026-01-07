package com.example.zz

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    private val tasks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val name = intent.getStringExtra("USER_NAME") ?: "User"

        val tvWelcome = findViewById<TextView>(R.id.textView6)
        val etTask = findViewById<EditText>(R.id.etTask)
        val tvList = findViewById<TextView>(R.id.tvList)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnAdd = findViewById<ImageButton>(R.id.btnAdd)
        val btnClear = findViewById<ImageButton>(R.id.btnClear)

        tvWelcome.text = "Hello $name 👋"

        btnAdd.setOnClickListener {
            val task = etTask.text.toString().trim()
            if (task.isNotEmpty()) {
                tasks.add(task)
                tvList.text = tasks.joinToString("\n") { "• $it" }
                tvCount.text = "Tasks (${tasks.size})"
                etTask.text.clear()
            }
        }

        btnClear.setOnClickListener {
            tasks.clear()
            tvList.text = "No tasks yet"
            tvCount.text = "Tasks (0)"
        }
    }
}
