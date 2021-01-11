package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.Item1Binding
import com.homework.uilistshomework.Adapter.ItemViewHolder as ItemViewHolder


class Adapter(val onClickListenerButton: OnClickListenerButton) :
    ListAdapter<String, ItemViewHolder>(ItemDiffCallback()) {

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    inner class ItemViewHolder(private val binding: Item1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup) : this(
            Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: String, position: Int) {
            binding.textViewLanguage.text = item
            binding.closeButton.setOnClickListener {
                onClickListenerButton.onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    interface OnClickListenerButton {
        fun onClick(position: Int)
    }
}

class ItemDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }
}
