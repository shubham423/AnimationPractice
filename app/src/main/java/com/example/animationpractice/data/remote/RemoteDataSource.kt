package com.example.animationpractice.data.remote

import com.example.animationpractice.models.MyCardsScreenResponse
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val api: Api
) {

    suspend fun getMyCardsScreenData(): Response<MyCardsScreenResponse> {
        return api.getMyCardsScreenData()
    }

}