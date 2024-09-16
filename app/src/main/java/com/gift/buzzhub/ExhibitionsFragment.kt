package com.gift.buzzhub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExhibitionsFragment : Fragment(){

    lateinit var recyclerView: RecyclerView
    var event_name = ArrayList<String>()
    var event_details = ArrayList<String>()
    var event_price = ArrayList<String>()
    var image_list = ArrayList<Int>()
    lateinit var adapter : exhibitionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_exhibitions, container, false)

        recyclerView = view.findViewById(R.id.exhibitionsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)


        event_name.add("Kunene Art Gallery")
        event_name.add("Exhibitions")
        event_name.add("Wits Exhibition")
        event_name.add("East Rand Gallery opening")
        event_name.add("XYZ Museum")
        event_name.add("Wits Exhibition")


        event_details.add("874 Katlehong Avenue, Johannesburg")
        event_details.add("45 Groove Street, Kempton Park")
        event_details.add("474 Brian Avenue, Pretoria")
        event_details.add("45 Groove Street, Kempton Park")
        event_details.add("874 Katlehong Avenue, Johannesburg")
        event_details.add("841 Katlehong Avenue, Eden Park")

        event_price.add("R650")
        event_price.add("R900")
        event_price.add("R210")
        event_price.add("R650")
        event_price.add("R580")
        event_price.add("R210")

        image_list.add(R.drawable.exhibit)
        image_list.add(R.drawable.exhibit_i)
        image_list.add(R.drawable.exhibit_ii)
        image_list.add(R.drawable.exhibit_iii)
        image_list.add(R.drawable.exhibit_v)
        image_list.add(R.drawable.exhibit_i)

        adapter = exhibitionsAdapter(event_name, event_details ,image_list, requireContext())

        recyclerView.adapter = adapter




        return view
    }
}