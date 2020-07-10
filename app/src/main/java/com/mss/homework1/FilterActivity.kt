package com.mss.homework1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : AppCompatActivity() {

    lateinit var filterList: List<FilterItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)

        val filters_on = intent.getStringArrayExtra("filters_on")!!
        filterList = intent.getStringArrayExtra("filters")!!.map { FilterItem(it, it in filters_on) }

        if (filters_on.count() < filterList.count()) filter_all.isChecked = false

        filters.layoutManager = LinearLayoutManager(this)
        filters.adapter = Adapter_filters(
            filterList,
            ::onCheck
        )

        filter_apply.setOnClickListener {
            val intent = Intent()
            intent.putExtra("filters_on", (filters.adapter as Adapter_filters).data.filter { it.value }.map { it.experience }.toTypedArray())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        filter_all.setOnClickListener {
            val b = filter_all.isChecked
            val adapter =
                Adapter_filters(
                    (filters.adapter as Adapter_filters).data
                        .map { item ->
                            FilterItem(item.experience, value = b)
                        },
                    ::onCheck
                )

            filters.adapter = adapter
        }

        activity_filter_close.setOnClickListener { onBackPressed() }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onCheck(position: Int) {
        filter_all.isChecked =
            (filters.adapter as Adapter_filters).data.map { it.value }.toBooleanArray().all { it }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBooleanArray(
            "checks",
            (filters.adapter as Adapter_filters)
                .data.map { it.value }.toBooleanArray()
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        var savedChecks = savedInstanceState.getBooleanArray("checks")
        if (savedChecks == null) savedChecks = List(filterList.size) { true }.toBooleanArray()

        val adapter =
            Adapter_filters(
                filterList
                    .mapIndexed { index, fl ->
                        FilterItem(fl.experience, savedChecks[index])
                    },
                ::onCheck
            )

        filters.adapter = adapter
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED, Intent())
        finish()
    }
}
