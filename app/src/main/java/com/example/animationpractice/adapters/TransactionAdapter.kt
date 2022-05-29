 package com.example.animationpractice.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animationpractice.databinding.ItemTransactionLayoutBinding
import com.example.animationpractice.models.Transaction

 class TransactionAdapter(private val list: List<Transaction>): RecyclerView.Adapter<TransactionAdapter.TransactionAdapterViewHolder>() {


    class TransactionAdapterViewHolder(private val binding: ItemTransactionLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            binding.category.text=transaction.category
            binding.name.text=transaction.name
            binding.amount.text="\$"+"${transaction.cost.amount}"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionAdapterViewHolder {
        val binding = ItemTransactionLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}
