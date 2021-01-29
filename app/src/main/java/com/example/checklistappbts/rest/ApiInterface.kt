package com.example.checklistappbts.rest

import com.example.checklistappbts.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun postRegister(@Body register: RegisterModel): Call<RegisterResponse>

    @POST("/login")
    fun postLogin(@Body login: LoginModel): Call<LoginResponse>

    @GET("/checklist")
    fun getChecklist(@Body checklist: ChecklistModel): Call<ChecklistResponse>
}