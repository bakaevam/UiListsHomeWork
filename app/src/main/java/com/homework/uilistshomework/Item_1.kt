package com.homework.uilistshomework

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Item_1 : ViewModel() {
    private var liveData: MutableLiveData<MutableList<String>>? = null

    var listLanguages = listOf(
        "JavaScript", "HTML", "CSS", "SQL", "Java", "Python", "PHP", "C#",
        "C++", "Kotlin", "Swift", "Ruby", "Go", "Assembly", "C", "Scala", "Perl"
    )

    fun getData(): LiveData<MutableList<String>> {
        if (liveData == null) {
            liveData = MutableLiveData()
            loadData()
        }
        return liveData!!
    }

    private fun loadData() {
        liveData!!.value = listLanguages as MutableList
    }

    fun deleteItem(position: Int) {
        if (liveData!!.value != null) {
            val list: MutableList<String> = mutableListOf()
            list.addAll(liveData!!.value as MutableList)
            list.removeAt(position)
            liveData!!.value = list

            Log.v("DELETE ITEM", list[position])
        }
    }
}