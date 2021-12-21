package com.example.week06day01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var editText:TextView? = null
    private var drawerLayout:DrawerLayout?=null
    private var toolbar:Toolbar?=null
    private var navigationView:NavigationView?=null
    private var recyclerView:RecyclerView?=null
    private var floatingActionButton:FloatingActionButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var email =intent.getStringExtra("email")

        connectView()
        editText?.text= email
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setDrawer()
       // try {
            updateEmailInHeader(email)
        //}catch (e:NullPointerException){

       // }

        drawerClicks()

        openAddStoryActivity()
        displayStories()

    }

    private fun updateEmailInHeader(email:String?){
        val headerView= navigationView?.getHeaderView(0)
        val textViewEmail= headerView?.findViewById<TextView>(R.id.tvEmail1Profile)
        textViewEmail?.text = email
    }
    private fun setDrawer(){
var toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

    }
// translation the marker to hamburger
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                drawerLayout?.openDrawer(GravityCompat.START)
                true
            }else -> true
        }
    }
    private fun connectView(){
        editText=findViewById(R.id.tViewEmail)
        drawerLayout=findViewById(R.id.drawer)
        toolbar=findViewById(R.id.toolbar)
        navigationView=findViewById(R.id.navView)
        recyclerView=findViewById(R.id.storiesRecyclerView)
        floatingActionButton=findViewById(R.id.btnAddStory)
    }
    //specifies which line  click it
    private fun drawerClicks(){
     navigationView?.setNavigationItemSelectedListener {
         when(it.itemId){
             R.id.home -> {
                 drawerLayout?.closeDrawer(GravityCompat.START)
                 true
             }
             R.id.logout ->{
                finish()
                 val i = Intent(this,LoginActivity::class.java)
                 startActivity(i)
                 true
             }
             else -> true
         }
     }
    }
    private fun openAddStoryActivity(){
        floatingActionButton?.setOnClickListener{
            val i =Intent(this,AddStoryActivity::class.java)
            startActivity(i)
        }
    }
    private fun displayStories(){
        val storiesArray =ArrayList<story>()
        storiesArray.add(
            story("this is my story ", "this is subtitle "
            ,"Welcome to my story I will show you how O learnt")
        )
        storiesArray.add(story("this is my second story ", "this is subtitle "
            ,"Welcome to my story I will show you how O learnt Welcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to " +
                    "my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learntWelcome to my fifth story I will show you how O learnt"))
        storiesArray.add(story("this is my third story ", "this is subtitle "
            ,"Welcome to my story I will show you how O learnt"))
        storiesArray.add(story("this is my forth story ", "this is subtitle "
            ,"Welcome to my fifth story I will show you how O learnt"))


        val custemAdapter= CustemAdapter(storiesArray,this)
        recyclerView?.adapter = custemAdapter

        if (intent.getStringExtra("title")!=null){
            val title = intent.getStringExtra("title")
            val subtitle = intent.getStringExtra("subTitle")
            val desc = intent.getStringExtra("desc")

            val  newStory = story(title!!,subtitle!!,desc!!)
            storiesArray.add(newStory)

            custemAdapter.notifyDataSetChanged()
        }
    }
}