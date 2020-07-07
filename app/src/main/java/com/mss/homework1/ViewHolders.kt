package com.mss.homework1

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_info.view.*

class UserHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var userInfo: User

    fun bind(userInfo: User) {
        view.apply {
            uName.text = userInfo.name
            uGrade.text = userInfo.grade
            uGitHub.setOnClickListener {
                view.context.startActivity(
                    Intent(Intent.ACTION_VIEW, Uri.parse(userInfo.link))
                )
            }
        }

        this.userInfo = userInfo
    }
}