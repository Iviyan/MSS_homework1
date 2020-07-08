package com.mss.homework1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val data: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int = position
        /*when (position) {
            0 -> 0
            1 -> 1
            2 -> 2
            3 -> 3
        }*/
        //return super.getItemViewType(position)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> UserHolder(inflater.inflate(R.layout.user_info, parent, false))
            1 -> ProjectHolder(inflater.inflate(R.layout.project_info, parent, false))
            else -> throw Exception("Wrong viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as UserHolder).bind(data[position] as User)
            1 -> (holder as ProjectHolder).bind(data[position] as Project)
        }
    }

    override fun getItemCount() = data.size
}