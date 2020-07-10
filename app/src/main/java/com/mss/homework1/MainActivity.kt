package com.mss.homework1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var skills = listOf<Skill>(
        Skill("Kotlin", "7d"),
        Skill("C#", "2y"),
        Skill("Javascript", "2y"),
        Skill("SQL", "<1m"),
        Skill("C++", "3m"),
        Skill("Pascal", ">5y")
    )

    private var filters: List<String> = listOf(
        "<1y",
        "2y",
        "3y",
        ">3y"
    )
    private var filters_on: List<String> = filters
    private val filtersCount get() = filters.count()

    fun filter_test(s: String): Boolean {
        val sdays = experienceToDays(s)
        for (test in filters_on) {
            if (s == test) return true
            val tdays = experienceToDays(test, true)
            if (test[0] == '>' || test[0] == '<') {
                if (test[0] == '>' && sdays > tdays) return true
                if (test[0] == '<' && sdays < tdays) return true
            }
        }
        return false
    }

    fun Filter(): List<Skill> {
        if (filters_on.count() == filtersCount) return skills
        if (filters_on.count() == 0) return listOf()
        return skills.filter {
            filter_test(it.experience)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main.addItemDecoration(ItemDecoration(14))
        main.layoutManager = LinearLayoutManager(this)
        loadAdapter()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            filters_on = data?.getStringArrayExtra("filters_on")!!.toList()
            loadAdapter()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putStringArray("filters_on", filters_on.toTypedArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        filters_on = savedInstanceState.getStringArray("filters_on")!!.asList()
        loadAdapter()
    }

    fun loadAdapter() {
        main.adapter = Adapter_main(
            listOf(
                User("Воркунов Иван", "10 класс", "https://github.com/Zagadochnik37"),
                Project("Это, вероятно, должен быть важный проект, хотя, кто его знает..."),
                SkillsHeader()
            ) + Filter(),
            filters,
            filters_on
        )
    }
}
