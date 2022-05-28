package com.example.animationpractice.data.remote

import com.example.animationpractice.models.MyCardsScreenResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("users/11/cards/")
    suspend fun getMyCardsScreenData(): Response<MyCardsScreenResponse>
}