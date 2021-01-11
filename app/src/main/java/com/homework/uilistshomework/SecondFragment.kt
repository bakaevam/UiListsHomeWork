package com.homework.uilistshomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random


class SecondFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewSecond)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = SecondAdapter().apply {
            list = create()
        }

        return view
    }

    private fun create(): MutableList<Item> {
        var createList: MutableList<Item> = mutableListOf()
        val size = 17
        var list: List<String> = listOf("JavaScript", "HTML", "CSS", "SQL", "Java", "Python",
                "PHP", "C#", "C++", "Kotlin", "Swift", "Ruby", "Go", "Assembly", "C", "Scala", "Perl")
        for (i in 0..size) {
            createList.add(Item(Random.nextInt(0, 2), list[Random.nextInt(0, 17)]))
        }

        return createList
    }
}