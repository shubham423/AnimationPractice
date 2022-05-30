package com.example.animationpractice.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.animationpractice.R
import com.example.animationpractice.adapters.CardsAdapter
import com.example.animationpractice.databinding.FragmentCardsBinding
import com.example.animationpractice.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import java.util.*


@AndroidEntryPoint
class CardsFragment : Fragment() {

    private lateinit var binding: FragmentCardsBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: CardsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initObservers()
        mainViewModel.getCardsScreenResponse()
    }

    private fun initObservers() {
        mainViewModel.readMyCardsScreenData.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                binding.balance.text = "\$"+"${NumberFormat.getNumberInstance(Locale.US).format(it[0].myCardsScreenResponse.balance.amount)}"
                binding.userImage.load(it[0].myCardsScreenResponse.avatar)
                adapter = CardsAdapter(it[0].myCardsScreenResponse.cards){card,binding->

                    val extra= FragmentNavigatorExtras(binding.card to "card_wide")
                    val bundle = bundleOf("card" to card)
                    findNavController().navigate(R.id.action_cardsFragment_to_cardDetailFragment,bundle,null,extra)

                }
                binding.rvCards.adapter = adapter

            }

        }
    }
}

