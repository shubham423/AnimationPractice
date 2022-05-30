package com.example.animationpractice.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animationpractice.adapters.CardsAdapter.*
import com.example.animationpractice.databinding.ItemCardLayoutBinding
import com.example.animationpractice.models.Card

class CardsAdapter(private val list: List<Card>, private val onCardClicked: (card: Card) -> Unit): RecyclerView.Adapter<CastAdapterViewHolder>() {

    class CastAdapterViewHolder(private val binding: ItemCardLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(
            card: Card,
            onCardClicked: (card: Card) -> Unit,
        ) {
            binding.card.setCardBackgroundColor(Color.parseColor(card.colour))
            binding.root.setOnClickListener {
                onCardClicked(card)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAdapterViewHolder {
        val binding = ItemCardLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CastAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CastAdapterViewHolder, position: Int) {
        holder.bind(list[position],onCardClicked)
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}
