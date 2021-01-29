package com.example.checklistappbts.pages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.checklistappbts.R
import com.example.checklistappbts.models.LoginModel
import com.example.checklistappbts.models.LoginResponse
import com.example.checklistappbts.models.RegisterModel
import com.example.checklistappbts.models.RegisterResponse
import com.example.checklistappbts.rest.ApiClient
import com.example.checklistappbts.rest.ApiInterface
import kotlinx.android.synthetic.main.login_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)
        onClickGroup()
    }

    private fun onClickGroup() {
        btnLogin.setOnClickListener {
            var textUsername = etUsername.text.toString()
            var textPassword = etPassword.text.toString()

            Log.d("username", textUsername)
            Log.d("password", textPassword)

            val login = LoginModel(textUsername, textPassword)
            val loginCall = ApiClient.getClient()?.create(ApiInterface::class.java)?.postLogin(login)
            loginCall?.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful){
                        val message = response.body()!!.data
                        Log.d("message", message!!.toString())
                        Toast.makeText(applicationContext, "Logged In", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@LoginActivity, ChecklistActivity::class.java))
                    } else {
                        Toast.makeText(applicationContext, "Log In Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Connection Failed", Toast.LENGTH_SHORT).show()
                    Log.d("Failed", t.message!!)
                }
            })
        }

        tvCreateAccount.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }
}