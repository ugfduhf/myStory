package com.example.week06day01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var editText:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email =intent.getStringExtra("email")


connectView()
        editText?.text= email
    }
    private fun connectView(){
        editText=findViewById(R.id.tViewEmail)
    }
}