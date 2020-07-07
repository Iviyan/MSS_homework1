package com.mss.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main.layoutManager = LinearLayoutManager(this)
        main.adapter = Adapter(
            listOf(
                User("Воркунов Иван", "1 курс", "https://github.com/Zagadochnik37")
            )
        )

    }
}