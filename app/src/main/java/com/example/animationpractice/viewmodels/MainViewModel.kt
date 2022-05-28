package com.example.animationpractice.viewmodels

import androidx.lifecycle.*
import com.example.animationpractice.data.Repository
import com.example.animationpractice.data.database.entities.MyCardsScreenEntity
import com.example.animationpractice.models.MyCardsScreenResponse
import com.example.animationpractice.utils.NetworkResult
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


    var cardsScreenResponse: MutableLiveData<NetworkResult<MyCardsScreenResponse>> = MutableLiveData()


    fun getCardsScreenResponse() = viewModelScope.launch {
        try {
            val response= repository.remote.getMyCardsScreenData()
            if (response.isSuccessful){
                cardsScreenResponse.value= NetworkResult.Success(response.body()!!)
                (cardsScreenResponse.value as NetworkResult.Success<MyCardsScreenResponse>).data?.let { MyCardsScreenEntity(it) }
                    ?.let { insertMyCardsScreenData(it) }
            }
        } catch (e: Exception) {
            cardsScreenResponse.value = NetworkResult.Error("Some error occured.")
        }
    }

}