package com.gift.buzzhub

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FirstFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var addButton: FloatingActionButton
    lateinit var deleteButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var nameList=ArrayList<String>()
        var detailsList = ArrayList<String>()
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

        recyclerView = view.findViewById(R.id.eventsRecyclerView)
        // Inflate the layout for this fragment
        var adapter = ConcertsHostAdapter(nameList,detailsList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)


        return view

        addButton.setOnClickListener{

        }

        deleteButton.setOnClickListener{

        }
    }


}