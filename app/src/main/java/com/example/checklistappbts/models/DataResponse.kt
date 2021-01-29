package com.example.checklistappbts.models

import com.google.gson.annotations.SerializedName

data class DataResponse (
    @SerializedName("token")
    val token: String? = null
)
