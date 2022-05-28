package com.example.animationpractice.models


import com.google.gson.annotations.SerializedName

data class MyCardsScreenResponse(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("balance")
    val balance: Balance,
    @SerializedName("cards")
    val cards: List<Card>
)