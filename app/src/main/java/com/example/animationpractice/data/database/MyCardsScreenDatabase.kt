package com.example.animationpractice.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.animationpractice.data.database.entities.MyCardsScreenEntity

@Database(
    entities = [MyCardsScreenEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CardsScreenTypeConverter::class)
abstract class MyCardsScreenDatabase: RoomDatabase() {

    abstract fun cardScreenDao():CardsScreenDao

}