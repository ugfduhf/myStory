package com.example.week06day01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var editText:TextView? = null
    private var drawerLayout:DrawerLayout?=null
    private var toolbar:Toolbar?=null
    private var navigationView:NavigationView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email =intent.getStringExtra("email")


        connectView()
        editText?.text= email

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setDrawer()
        updateEmailInHeader(email!!)
    }
    private fun updateEmailInHeader(email:String){
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
    }
}