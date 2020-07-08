package com.mss.homework1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val data: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int =
        when (data[position]) {
            is User -> 0
            is Project -> 1
            is SkillsHeader -> 2
            is Skill -> 3
            else -> throw Exception("Wrong type")
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> UserHolder(inflater.inflate(R.layout.user_info, parent, false))
            1 -> ProjectHolder(inflater.inflate(R.layout.project_info, parent, false))
            2 -> SkillsHeaderHolder(inflater.inflate(R.layout.skills_header, parent, false))
            3 -> SkillHolder(inflater.inflate(R.layout.skill_item, parent, false))
            else -> throw Exception("Wrong viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> (holder as UserHolder).bind(data[position] as User)
            1 -> (holder as ProjectHolder).bind(data[position] as Project)
            3 -> (holder as SkillHolder).bind(data[position] as Skill)
        }
    }

    override fun getItemCount(): Int = data.size
}
