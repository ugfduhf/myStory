package com.example.week06day01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class StoryDetailsActivity : AppCompatActivity() {
    private var toolbarview:Toolbar?=null
    private var textViewStoryDesc:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_details)

        connectViews()
        setSupportActionBar(toolbarview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Receive Variables
        val title =intent.getStringExtra("title")
        val description=intent.getStringExtra("description")

        supportActionBar?.title=title
        toolbarview?.setNavigationOnClickListener {
            onBackPressed()
        }
        textViewStoryDesc?.text = description
        textViewStoryDesc?.setMovementMethod(ScrollingMovementMethod())

    }
    private fun connectViews(){
        toolbarview=findViewById(R.id.toolbar)
        textViewStoryDesc=findViewById(R.id.textViewDesc)

    }
}