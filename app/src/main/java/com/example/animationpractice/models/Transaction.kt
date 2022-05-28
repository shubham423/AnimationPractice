package com.example.animationpractice.models


import com.google.gson.annotations.SerializedName

data class Transaction(
    @SerializedName("category")
    val category: String,
    @SerializedName("cost")
    val cost: Cost,
    @SerializedName("name")
    val name: String
)