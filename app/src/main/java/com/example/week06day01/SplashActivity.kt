package com.example.week06day01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLoginScreen()
    }
    private fun moveToLoginScreen(){
        // call this when your activity is done and should be closed
        Handler(Looper.myLooper()!!).postDelayed({
        finish()
        val i =Intent(this,LoginActivity::class.java)
        //the next code  use to delayed for code
        startActivity(i)
        },4000)

    }
}