package com.gift.buzzhub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {

    lateinit var hostName:TextView
    lateinit var hostClicks:TextView
    lateinit var hostEvents:TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        // Inflate the layout for this fragment

        val hName:String = arguments?.getString("hostName")?:"Guest"
        val hClicks =  arguments?.getInt("hostClicks")?:"N/A"
        val hEvents = arguments?.getInt("hostEvents")?: "N/A"
        hostName = view.findViewById(R.id.hostName)
        hostClicks = view.findViewById(R.id.hostClicks)
        hostEvents = view.findViewById(R.id.hostEvents)
        hostName.text = hName
        hostClicks.text = hClicks.toString()
        hostEvents.text = hEvents.toString()

        return view
    }


}