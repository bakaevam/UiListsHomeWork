package com.homework.uilistshomework

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.homework.uilistshomework.databinding.Item1Binding
import com.homework.uilistshomework.Adapter.ItemViewHolder as ItemViewHolder

class Adapter: RecyclerView.Adapter<ItemViewHolder>() {

    var list: List<String> = listOf("JavaScript", "HTML", "CSS", "SQL", "Java", "Python",
        "PHP", "C#", "C++", "Kotlin", "Swift", "Ruby", "Go", "Assembly", "C", "Scala", "Perl")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemViewHolder(private val binding: Item1Binding): RecyclerView.ViewHolder(binding.root) {
        constructor(parent: ViewGroup): this(
            Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        fun bind(item: String) {
            binding.textViewLanguage.text = item
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
}
