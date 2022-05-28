package com.example.animationpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.animationpractice.databinding.ActivityMainBinding
import com.example.animationpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObservers()
        mainViewModel.getCardsScreenResponse()
    }

    private fun initObservers() {
      mainViewModel.readMyCardsScreenData.observe(this){
          if (it.isNotEmpty()){
              binding.balance.text=it[0].myCardsScreenResponse.balance.amount.toString()
              binding.userImage.load(it[0].myCardsScreenResponse.avatar)
          }

      }
    }
}