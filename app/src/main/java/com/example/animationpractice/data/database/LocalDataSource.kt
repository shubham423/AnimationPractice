package com.example.animationpractice.data.database

import androidx.lifecycle.LiveData
import com.example.animationpractice.data.database.entities.MyCardsScreenEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: CardsScreenDao
) {

    fun readMyCardsScreenResponse(): LiveData<List<MyCardsScreenEntity>> {
        return dao.readData()
    }


    suspend fun insertMyCardsScreenResponse(entity: MyCardsScreenEntity) {
        dao.insertCardScreenData(entity)
    }


}