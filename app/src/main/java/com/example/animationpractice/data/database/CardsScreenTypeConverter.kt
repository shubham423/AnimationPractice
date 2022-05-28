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

    @TypeConverter
    fun balanceToString(balance: Balance): String {
        return gson.toJson(balance)
    }

    @TypeConverter
    fun stringToBalance(data: String): Balance {
        val listType = object : TypeToken<Balance>() {}.type
        return gson.fromJson(data, listType)
    }


    @TypeConverter
    fun cardToString(card: Card): String {
        return gson.toJson(card)
    }

    @TypeConverter
    fun stringToCard(data: String): Card {
        val listType = object : TypeToken<Card>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun costToString(cost: Cost): String {
        return gson.toJson(cost)
    }

    @TypeConverter
    fun stringToCost(data: String): Cost {
        val listType = object : TypeToken<Cost>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun transactionToString(transaction: Transaction): String {
        return gson.toJson(transaction)
    }

    @TypeConverter
    fun stringToTransaction(data: String): Transaction {
        val listType = object : TypeToken<Transaction>() {}.type
        return gson.fromJson(data, listType)
    }
}
