package com.example.animationpractice.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    @SerializedName("card_border_color")
    val cardBorderColor: String,
    @SerializedName("colour")
    val colour: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("transactions")
    val transactions: List<Transaction>
):Parcelable