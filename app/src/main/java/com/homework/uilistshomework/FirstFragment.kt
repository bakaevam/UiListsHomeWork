package com.homework.uilistshomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FirstFragment : Fragment(), Adapter.OnClickListenerButton {

    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: Item_1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        viewModel = ViewModelProvider(this).get(Item_1::class.java)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        var adapter = Adapter(this)
        recyclerView.adapter = adapter

        viewModel.getData().observe(this, Observer { adapter.submitList(it) })

        return view
    }

    override fun onClick(position: Int) {
        viewModel.deleteItem(position)
    }
}