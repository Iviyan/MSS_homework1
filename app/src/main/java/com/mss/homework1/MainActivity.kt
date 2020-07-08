package com.mss.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main.addItemDecoration(ItemDecoration(14))
        main.layoutManager = LinearLayoutManager(this)
        main.adapter = Adapter(
            listOf(
                User("Воркунов Иван", "10 класс", "https://github.com/Zagadochnik37"),
                Project("Это, вероятно, должен быть важный проект, хотя, кто его знает..."),
                SkillsHeader(),
                Skill("Kotlin", "4 дня"),
                Skill("C#", "2 года"),
                Skill("Javascript", "2 года"),
                Skill("SQL", "<1 месяца"),
                Skill("C++", "3 месяца")

            )
        )

    }
}