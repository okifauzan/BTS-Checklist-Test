package com.example.checklistappbts.models

import com.google.gson.annotations.SerializedName

data class RegisterResponse (
    @SerializedName("statusCode")
    var statusCode: String? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("errorMessage")
    var errorMessage: String? = null
)