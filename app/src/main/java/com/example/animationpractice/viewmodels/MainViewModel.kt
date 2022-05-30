package com.example.animationpractice.viewmodels

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animationpractice.data.Repository
import com.example.animationpractice.data.database.entities.MyCardsScreenEntity
import com.example.animationpractice.models.MyCardsScreenResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    @ApplicationContext private val context: Context
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

    @RequiresApi(Build.VERSION_CODES.M)
     fun hasInternetConnection(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}