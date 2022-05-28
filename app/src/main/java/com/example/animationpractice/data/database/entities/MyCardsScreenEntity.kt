package com.example.animationpractice.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.animationpractice.models.MyCardsScreenResponse
import com.example.animationpractice.utils.Constants.CARD_SCREEN_TABLE


@Entity(tableName = CARD_SCREEN_TABLE)
class MyCardsScreenEntity(
    var myCardsScreenResponse: MyCardsScreenResponse
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}