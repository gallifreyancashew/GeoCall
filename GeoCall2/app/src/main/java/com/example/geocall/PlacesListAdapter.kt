package com.example.geocall

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_places.view.*

class PlacesListAdapter (
    var placesList: List<PlacesListItem>
) : RecyclerView.Adapter<PlacesListAdapter.PlacesListViewHolder>() {

    inner class PlacesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_places, parent, false)
        return PlacesListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return placesList.size
    }

    override fun onBindViewHolder(holder: PlacesListViewHolder, position: Int) {
        holder.itemView.apply {
            txv_name.text = placesList[position].name
            //txv_distance.text = placesList[position].distance.toString() + "km away"
            txv_distance.text = placesList[position].contact.toString()
            txv_rating.text = "Rating: " + placesList[position].rating.toString() + "/5"
            btn_dial.setOnClickListener {
                val intentCall = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + placesList[position].contact.toString()))
                context.startActivity(intentCall)
            }
        }
    }

}