package com.example.checklistappbts.models

import com.google.gson.annotations.SerializedName

data class RegisterModel (
    @SerializedName ("username")
    var username: String?,

    @SerializedName ("email")
    var email: String?,

    @SerializedName ("password")
    var password: String?
)