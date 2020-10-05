package com.example.geocall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            txv_distance.text = placesList[position].distance.toString() + "km away"
            txv_rating.text = "Rating: " + placesList[position].rating.toString() + "/5"
        }
    }

}