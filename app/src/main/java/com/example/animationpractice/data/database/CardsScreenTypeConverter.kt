package com.example.animationpractice.data.database

import androidx.room.TypeConverter
import com.example.animationpractice.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CardsScreenTypeConverter{
    var gson = Gson()

    @TypeConverter
    fun myCardsScreenResponseToString(myCardsScreenResponse: MyCardsScreenResponse): String {
        return gson.toJson(myCardsScreenResponse)
    }

    @TypeConverter
    fun stringToMyCardsScreenResponse(data: String): MyCardsScreenResponse {
        val listType = object : TypeToken<MyCardsScreenResponse>() {}.type
        return gson.fromJson(data, listType)
    }

}
