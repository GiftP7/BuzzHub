package com.gift.buzzhub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ComedyFragment: Fragment() {

    val eventDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val eventMyReference: DatabaseReference = eventDatabase.reference.child("Events").child("Active Events")


    lateinit var recyclerView: RecyclerView
    var event_name = ArrayList<String>()
    var event_details = ArrayList<String>()
    var event_price = ArrayList<String>()
    var image_list = ArrayList<Int>()
    lateinit var adapter : comedyAdapter
    lateinit var Tadapter: UserEventOverviewAdapter
    var eventList = ArrayList<Events>()
    var imgList = ArrayList<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         var view = inflater.inflate(R.layout.activity_comedy, container, false)

        recyclerView = view.findViewById(R.id.comedyRecyclerView)
        fillArray(imgList)
        retrieveDataFromDatabase(imgList)
        for (event in eventList){

        }
        /*recyclerView.layoutManager = LinearLayoutManager(context)




        event_name.add("Nina Hastie:Thuma Nina")
        event_name.add("Skhumba")
        event_name.add("Trevor Noah")
        event_name.add("Celeste Ntuli")
        event_name.add("Mpho Popps")
        event_name.add("Tumi Morake")

        event_details.add("874 Katlehong Avenue, Johannesburg")
        event_details.add("45 Groove Street, Kempton Park")
        event_details.add("474 Brian Avenue, Pretoria")
        event_details.add("45 Groove Street, Kempton Park")
        event_details.add("841 Katlehong Avenue, Eden Park")
        event_details.add("45 Groove Street, Kempton Park")

        event_price.add("R650")
        event_price.add("R900")
        event_price.add("R210")
        event_price.add("R650")
        event_price.add("R580")
        event_price.add("R210")

        image_list.add(R.drawable.nina_hastie)
        image_list.add(R.drawable.skhumba)
        image_list.add(R.drawable.trevor_noah)
        image_list.add(R.drawable.celeste_ntuli)
        image_list.add(R.drawable.mpho_popps)
        image_list.add(R.drawable.tumi_morake)

        adapter = comedyAdapter(event_name ,event_details,event_price,image_list, requireContext())

        recyclerView.adapter = adapter*/

        return view
    }

    fun fillArray(imgList: ArrayList<Int>) {


        imgList.add(R.drawable.colourfest)
        imgList.add(R.drawable.dstvdeliciousimg)
        imgList.add(R.drawable.justdanceimg)
        imgList.add(R.drawable.rockingthedaisiesimg)


    }

    fun retrieveDataFromDatabase(imgList: ArrayList<Int>) {
        eventMyReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                eventList.clear()
                for(eachEvent in snapshot.children){
                    val event = eachEvent.getValue(Events::class.java)
                    if(event != null && event.eventCategory == "Comedy"){
                        eventList.add(event)
                    }
                }
                recyclerView.layoutManager = LinearLayoutManager(context)
                fillArray(imgList)
                Tadapter = UserEventOverviewAdapter(eventList,imgList,requireContext())
                recyclerView.adapter = Tadapter


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


    }

    /*fun addClicks(eventId){

    }*/


}
