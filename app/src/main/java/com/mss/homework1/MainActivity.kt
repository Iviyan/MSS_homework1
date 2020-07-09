package com.mss.homework1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main.addItemDecoration(ItemDecoration(14))
        main.layoutManager = LinearLayoutManager(this)
        main.adapter = Adapter_main(
            listOf(
                User("Воркунов Иван", "10 класс", "https://github.com/Zagadochnik37"),
                Project("Это, вероятно, должен быть важный проект, хотя, кто его знает..."),
                SkillsHeader(),
                Skill("Kotlin", "7d"),
                Skill("C#", "2y"),
                Skill("Javascript", "2y"),
                Skill("SQL", "<1m"),
                Skill("C++", "3m")

            )
        )
    }
}
