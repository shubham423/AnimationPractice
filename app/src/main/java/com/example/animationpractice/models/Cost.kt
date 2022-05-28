package com.example.animationpractice.models


import com.google.gson.annotations.SerializedName

data class Cost(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency")
    val currency: String
)