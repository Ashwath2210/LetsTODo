package com.example.letstodotask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import missing.namespace.R


class HistoryTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_task)

        // Here, you would fetch the list of completed tasks from the database
        // and populate them dynamically in the layout.
    }
}
