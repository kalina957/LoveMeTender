package com.example.kalina.softuni_recyclerview.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kalina.softuni_recyclerview.view.PoiItemViewHolder
import com.example.kalina.softuni_recyclerview.R
import com.example.kalina.softuni_recyclerview.model.POIReqRespItem

class POIAdapter() : RecyclerView.Adapter<PoiItemViewHolder>() {

    private var dataList: ArrayList<POIReqRespItem> = ArrayList()
    private var imgList: ArrayList<String> = ArrayList()

    constructor( dataList: ArrayList<POIReqRespItem>) : this() {
        this.dataList = dataList
        imgList.add("https://www.amsterdammagazine.com/app/uploads/2017/10/harbourclub-kitchen-terras.jpg")
        imgList.add("https://c.tfstatic.com/w_656,h_368,c_fill,g_auto:subject,q_auto,f_auto/restaurant_photos/911/354911/source/kite-restaurant-bar-restaurant-afca3.jpg")
        imgList.add("https://q-cf.bstatic.com/images/hotel/max1024x768/195/195571737.jpg")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poi, parent, false)
        val holder: PoiItemViewHolder =
            PoiItemViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: PoiItemViewHolder, position: Int) {
        if(dataList.count()!=0){
            Glide.with(holder.image).load(imgList[position]).into(holder.image)
            holder.text?.setText(dataList[position].name)
            holder.text?.setTextColor(Color.parseColor(dataList[position].color))
        }
        else{
            Log.d("DataListCount","EmptyArrayBro")
        }
    }
}
