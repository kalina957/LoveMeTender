package com.example.kalina.softuni_recyclerview.model


import com.google.gson.annotations.SerializedName

data class POIReqRespItem(
    @SerializedName("color")
    val color: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)