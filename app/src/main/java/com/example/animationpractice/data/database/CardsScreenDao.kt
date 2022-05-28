package com.example.animationpractice.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animationpractice.data.database.entities.MyCardsScreenEntity

@Dao
interface CardsScreenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCardScreenData(cardScreenData: MyCardsScreenEntity)

    @Query("SELECT * FROM CARD_SCREEN_TABLE ORDER BY id ASC")
    fun readData(): LiveData<List<MyCardsScreenEntity>>
}