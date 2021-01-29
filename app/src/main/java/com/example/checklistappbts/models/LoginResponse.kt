package com.example.checklistappbts.models

import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.util.*

data class LoginResponse (
    @SerializedName("statusCode")
    var statusCode: String? = null,

    @SerializedName("message")
    var message: String? = null,

    @SerializedName("token")
    var token: String? = null,

    @SerializedName("data")
    var data: DataResponse
)
