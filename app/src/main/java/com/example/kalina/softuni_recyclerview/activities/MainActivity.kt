package com.example.kalina.softuni_recyclerview.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import kotlinx.android.synthetic.main.activity_main.*
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.kalina.softuni_recyclerview.adapters.POIAdapter
import com.example.kalina.softuni_recyclerview.R
import com.example.kalina.softuni_recyclerview.model.POIReqRespItem


class MainActivity : AppCompatActivity() {

    private var dataList: ArrayList<POIReqRespItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar: Toolbar = this.toolbar_main
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getPOIData()
    }

    private fun getPOIData() {
        AndroidNetworking.initialize(this)
        var url : String = "https://dev.api.lovemetender.coffeeit.nl/pois/types"
        AndroidNetworking.get(url)
            .build()
            .getAsObjectList(
                POIReqRespItem::class.java,
                object : ParsedRequestListener<ArrayList<POIReqRespItem>> {

                    override fun onResponse(response: ArrayList<POIReqRespItem>?) {
                        if (response != null) {
                            dataList.addAll(response.toTypedArray())
                        }
                        setupRecView()
                    }

                    override fun onError(error: ANError) {
                        // handle error
                        Log.d("Error", error.message)
                    }
                })
    }

    private fun setupRecView() {
        var adapter: POIAdapter =
            POIAdapter(dataList)
        rec_view.layoutManager = LinearLayoutManager(this)
        rec_view.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
