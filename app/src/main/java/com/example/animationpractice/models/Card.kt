package com.example.animationpractice.models


import com.google.gson.annotations.SerializedName

data class Card(
    @SerializedName("card_border_color")
    val cardBorderColor: String,
    @SerializedName("colour")
    val colour: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("transactions")
    val transactions: List<Transaction>
)