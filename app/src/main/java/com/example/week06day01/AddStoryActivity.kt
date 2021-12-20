package com.example.week06day01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddStoryActivity : AppCompatActivity() {
    private var editTextTitle:EditText?=null
    private var editTextSubtitle:EditText?=null
    private var editTextDesc:EditText?=null
    private var buttonAddStory:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_story)

        connectView()
        fieldsValidation()
    }
    private fun connectView(){
        editTextTitle=findViewById(R.id.etTitleAdd)
        editTextSubtitle=findViewById(R.id.etSubtitleAdd)
        editTextDesc=findViewById(R.id.etdescriptionAdd)
        buttonAddStory=findViewById(R.id.btnAddStory)
    }
    private fun fieldsValidation(){
        buttonAddStory?.setOnClickListener {
            val title = editTextTitle?.text.toString()
            val subTitle= editTextSubtitle?.text.toString()
            val desc =editTextDesc?.text.toString()

            when {
                title.isEmpty() -> {
                    editTextTitle?.error = getString(R.string.enter_title)

                }
                subTitle.isEmpty() -> {
                    editTextSubtitle?.error = getString(R.string.enter_subtitle)
                }
                desc.isEmpty() -> {
                    editTextDesc?.error= getString(R.string.enter_description)
                }
                else -> {
                    // Add story now all fields have data
                    this.finish()
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("title",title)
                    i.putExtra("subTitle",subTitle)
                    i.putExtra("desc",desc)
                    startActivity(i)
                }
            }
        }
    }
}