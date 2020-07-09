package com.mss.homework1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

@Suppress("ClassName")
class Adapter_filters(private val data: List<FilterItem>) :
    RecyclerView.Adapter<CheckboxHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CheckboxHolder(inflater.inflate(R.layout.filter_item, parent, false) as CheckBox)
    }

    override fun onBindViewHolder(holder: CheckboxHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size
}

class CheckboxHolder(private val view: CheckBox) : RecyclerView.ViewHolder(view) {
    lateinit var filter: FilterItem

    fun bind(filter: FilterItem) {
        view.apply {
            this.text = filter.text
        }

        this.filter = filter
    }
}
