package com.example.kalina.softuni_recyclerview.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kalina.softuni_recyclerview.R

class PoiItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var text: TextView? = null
    var image: ImageView

    init {
        image = itemView.findViewById(R.id.img_poi)
        text = itemView.findViewById(R.id.txt_poi)
    }

}


