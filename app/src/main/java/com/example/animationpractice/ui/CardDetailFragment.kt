package com.example.animationpractice.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.transition.TransitionInflater
import com.example.animationpractice.adapters.TransactionAdapter
import com.example.animationpractice.databinding.FragmentCardDetailBinding
import com.example.animationpractice.models.Card
import com.google.android.material.appbar.AppBarLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CardDetailFragment : Fragment() {
    private lateinit var binding:FragmentCardDetailBinding
    private lateinit var adapter:TransactionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding= FragmentCardDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val card=arguments?.getParcelable<Card>("card")
        binding.cardName.text= card?.name ?: ""
        if (card != null) {
            binding.card.setCardBackgroundColor(Color.parseColor(card.colour))
        }
        setupRecyclerView(card)
    }

    private fun setupRecyclerView(card: Card?) {
        if (card != null) {
            adapter= TransactionAdapter(card.transactions)
        }
        binding.transactionsRv.adapter=adapter
    }
}