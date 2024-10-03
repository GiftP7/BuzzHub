package com.gift.buzzhub

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class UserEventOverviewAdapter(var eventList:ArrayList<Events>,
                                var imgList:ArrayList<Int>,
                                var context:Context): RecyclerView.Adapter<UserEventOverviewAdapter.ViewHolder>(){

                                    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
                                        var textViewName: TextView = itemView.findViewById(R.id.txtEventName)
                                        var textViewDetail: TextView = itemView.findViewById(R.id.txtEventDetails)
                                        var textViewPrice: TextView = itemView.findViewById(R.id.txtPrice)
                                        var eventImg: ImageView = itemView.findViewById(R.id.EventImage)
                                        var cardView: CardView = itemView.findViewById(R.id.eventsCardView)
                                    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text = eventList[position].eventName
        holder.textViewDetail.text = eventList[position].eventDetails
        holder.textViewPrice.text = "R${eventList[position].eventPrice.toString()}"
        holder.eventImg.setImageResource(imgList[position])
        val eventId = eventList[position].eventId
        val siteUrl = "https://pay.ozow.com/f45a2df7-88cb-4a67-a741-1e8dfbd67beb/bank-selection/"

        holder.itemView.setOnClickListener{
            openWebPage(context, siteUrl)
        }
    }

    private fun openWebPage(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}