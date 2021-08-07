package com.example.cartodevisita.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cartodevisita.data.CartaoDeVisita
import com.example.cartodevisita.databinding.ItemCardBinding

class CartaoAdapter :
    ListAdapter<CartaoDeVisita, CartaoAdapter.ViewHolder>(DiffCallback()) {
    var listenerShare: (View) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater , parent , false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
        private val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartaoDeVisita) {
            binding.tvNome.text = item.nome
            binding.tvTelefone.text = item.telefone.toString()
            binding.tvEmail.text = item.email
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.background))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }


        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<CartaoDeVisita>() {
    override fun areItemsTheSame(oldItem: CartaoDeVisita, newItem: CartaoDeVisita) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: CartaoDeVisita, newItem: CartaoDeVisita) =
        oldItem.id == newItem.id

}