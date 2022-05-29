package com.example.animationpractice.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.example.animationpractice.data.Repository
import com.example.animationpractice.data.database.entities.MyCardsScreenEntity
import com.example.animationpractice.models.MyCardsScreenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {


    val readMyCardsScreenData: LiveData<List<MyCardsScreenEntity>> = repository.local.readMyCardsScreenResponse()

    private fun insertMyCardsScreenData(entity: MyCardsScreenEntity) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.local.insertMyCardsScreenResponse(entity)
        }


    private var cardsScreenResponse: MutableLiveData<MyCardsScreenResponse> = MutableLiveData()


    fun getCardsScreenResponse() = viewModelScope.launch {
        try {
            val response= repository.remote.getMyCardsScreenData()
            if (response.isSuccessful){
                cardsScreenResponse.value= response.body()
                if (cardsScreenResponse.value!=null){
                    insertMyCardsScreenData(MyCardsScreenEntity(cardsScreenResponse.value!!))
                }


            }
        } catch (e: Exception) {
            Log.d("MainViewModel","some error occured")
        }
    }

}