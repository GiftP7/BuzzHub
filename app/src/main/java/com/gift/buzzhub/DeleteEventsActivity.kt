
package com.gift.buzzhub

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DeleteEventsActivity : AppCompatActivity() {

    lateinit var eventList:ArrayList<Events>
    lateinit var deleteEventsActivityRecycler: RecyclerView
    lateinit var adapter: DeleteEventsAdapter
    val eventDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    val eventMyReference: DatabaseReference = eventDatabase.reference.child("Events").child("Active Events")
    var hId:String = ""
    var hName:String = ""
    var imgList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delete_events)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.deleteEventsMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        deleteEventsActivityRecycler = findViewById(R.id.deleteEventsActivityRecycler)
        eventList = ArrayList<Events>()
        hId = intent.getStringExtra("hostId").toString()
        val hostEvents = intent.getIntExtra("hostEvents",0)
        hName = intent.getStringExtra("hostName").toString()
        val hostClicks = intent.getIntExtra("hostClicks",0)
        val hostCategory = intent.getStringExtra("hostCategory")
        retrieveDataFromDatabase(imgList)

    }

    fun retrieveDataFromDatabase(imgList: ArrayList<Int>) {
        eventMyReference.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                eventList.clear()
                for(eachEvent in snapshot.children){
                    val event = eachEvent.getValue(Events::class.java)
                    if(event != null && event.eventHostId == hId && event.eventHostName == hName){
                        eventList.add(event)
                    }
                }
                deleteEventsActivityRecycler.layoutManager = LinearLayoutManager(this@DeleteEventsActivity)
                fillArray(imgList)
                adapter = DeleteEventsAdapter(eventList,imgList,this@DeleteEventsActivity)
                deleteEventsActivityRecycler.adapter = adapter


            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    fun fillArray(imgList: ArrayList<Int>) {


        imgList.add(R.drawable.colourfest)
        imgList.add(R.drawable.dstvdeliciousimg)
        imgList.add(R.drawable.justdanceimg)
        imgList.add(R.drawable.rockingthedaisiesimg)


    }
}
