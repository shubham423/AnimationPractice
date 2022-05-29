package com.example.animationpractice.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Transaction(
    @SerializedName("category")
    val category: String,
    @SerializedName("cost")
    val cost: Cost,
    @SerializedName("name")
    val name: String
):Parcelable