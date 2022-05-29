package com.example.animationpractice.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cost(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency")
    val currency: String
):Parcelable