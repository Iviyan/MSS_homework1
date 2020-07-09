package com.mss.homework1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        filters.layoutManager = LinearLayoutManager(this)
        filters.adapter = Adapter_filters(
            listOf(
                FilterItem("<1y"),
                FilterItem("2y"),
                FilterItem("3y"),
                FilterItem(">3y")
            )
        )
    }
}
