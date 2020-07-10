package com.mss.homework1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

@Suppress("ClassName")
class Adapter_filters(val data: List<FilterItem>, val onCheck: (position: Int) -> Unit) :
    RecyclerView.Adapter<CheckboxHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CheckboxHolder(inflater.inflate(R.layout.filter_item, parent, false) as CheckBox)
    }

    override fun onBindViewHolder(holder: CheckboxHolder, position: Int) {
        val filter = data[position]
        holder.apply {
            view.text = filter.text
            view.isChecked = filter.value

            view.setOnCheckedChangeListener { _, v ->
                data[position].value = v
                onCheck(position)
            }
        }
    }

    override fun getItemCount(): Int = data.size
}

class CheckboxHolder(val view: CheckBox) : RecyclerView.ViewHolder(view)
