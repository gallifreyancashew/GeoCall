package com.example.geocall

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(private var title: List<String>, private var details: List<String>, private var images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>(){

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.title)
        val itemDetails: TextView = itemView.findViewById(R.id.details)
        val itemImage: ImageView = itemView.findViewById(R.id.image)

//        init {
//            itemImage.setOnClickListener{ v: View ->
//                val position = adapterPosition
//                Toast.makeText(itemView.context, "You clicked on item #${position+1}", Toast.LENGTH_SHORT).show()
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_welcome_page1, parent, false))
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetails.text = title[position]
        holder.itemImage.setImageResource(images[position])
    }

}