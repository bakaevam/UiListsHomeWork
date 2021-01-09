package com.homework.uilistshomework

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.Item1Binding
import com.homework.uilistshomework.databinding.Item2Binding
import com.homework.uilistshomework.databinding.Item2Binding.bind
import com.homework.uilistshomework.databinding.Item3Binding

class SecondAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var list: MutableList<Item>

    override fun getItemViewType(position: Int): Int {
        return list[position].first
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0 -> {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_2, parent, false)
                SecondItemViewHolder(parent)
            } else -> {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_3, parent, false)
                ThirdItemViewHolder(parent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var itemType = list[position].first
        val item = list[position].second
        when (itemType) {
            0 -> (holder as SecondItemViewHolder).bind(item)
            else ->  (holder as ThirdItemViewHolder).bind(item)
        }
    }

    class SecondItemViewHolder(private val binding: Item2Binding): RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup): this(
                Item2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: String) {
            binding.item2Text.text = item
        }
    }

    class ThirdItemViewHolder(private val binding: Item3Binding): RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup): this(
                Item3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: String) {
            binding.item3Text.text = item
        }
    }
}