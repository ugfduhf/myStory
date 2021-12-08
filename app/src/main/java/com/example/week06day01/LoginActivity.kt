package com.example.week06day01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
   private var editTextUserName:EditText?=null
  private  var editTextPassword:EditText?=null
   private var btnLogin:Button?=null
    private var checkbox:CheckBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectView()
        login()
       // checkFields()
    }
    private fun connectView(){
        editTextUserName=findViewById(R.id.eUserName)
        editTextPassword=findViewById(R.id.ePassword)
        btnLogin=findViewById(R.id.btnLogin)
        checkbox=findViewById(R.id.checkbox)
    }
    private fun login(){
        var array:ArrayList<User> = ArrayList()
        array.add(User("sys@mail.com","aa456"))
        array.add(User("toto@mail.com","aa123"))
        btnLogin?.setOnClickListener {
            val userName=editTextUserName?.text.toString()
            val password=editTextPassword?.text.toString()

            val user=User(userName,password)

            for (userArray in array){
                if (userArray.email == user.email &&
                    userArray.password == user.password){
                        finish()
                        val i = Intent(this,MainActivity::class.java)
                    i.putExtra("email",userArray.email)
                    startActivity(i)
                    //Toast.makeText(this,"welcome ${user.email}", Toast.LENGTH_LONG).show()
                    break
                }else if(userArray.email != user.email){
                    Toast.makeText(this, "the data is wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }

}
    private fun checkFields(){    // this fanction is stop
      btnLogin?.setOnClickListener {
         if (editTextUserName?.text?.isEmpty() == true ){
          editTextUserName?.setError("Enter your email")
         }else if(editTextPassword?.text?.isEmpty() == true){
          editTextPassword?.error = "Enter your password"
        }else{
           Toast.makeText(this,"check your data",Toast.LENGTH_LONG).show()
         }
       }
    }
}








