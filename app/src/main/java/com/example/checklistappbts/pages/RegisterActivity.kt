package com.example.checklistappbts.pages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.checklistappbts.R
import com.example.checklistappbts.models.RegisterModel
import com.example.checklistappbts.models.RegisterResponse
import com.example.checklistappbts.rest.ApiClient
import com.example.checklistappbts.rest.ApiInterface
import kotlinx.android.synthetic.main.register_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)
        onClickGroup()
    }

    private fun onClickGroup() {
        btnRegister.setOnClickListener {
            var textUsername = etRegisterUsername.text.toString()
            var textEmail = etRegisterEmail.text.toString()
            var textPassword = etRegisterPassword.text.toString()

            Log.d("username", textUsername)
            Log.d("email", textEmail)
            Log.d("password", textPassword)

            val registerModel = RegisterModel(textUsername, textEmail, textPassword)
            val registerCall = ApiClient.getClient()?.create(ApiInterface::class.java)?.postRegister(registerModel)
            registerCall?.enqueue(object : Callback<RegisterResponse>{
                override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                    if (response.isSuccessful){
                        val message = response.body()!!.message
                        Toast.makeText(applicationContext, "Register Complete", Toast.LENGTH_SHORT).show()
                        Log.d("message", message!!)
                    } else {
                        Toast.makeText(applicationContext, "Register Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Connection Failed", Toast.LENGTH_SHORT).show()
                    Log.d("Failed", t.message!!)
                }
            })
        }

        btnRegisterBack.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }
}