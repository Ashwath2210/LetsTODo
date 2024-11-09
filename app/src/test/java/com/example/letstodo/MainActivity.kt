package com.example.letstodotask

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var taskListLayout: LinearLayout
    private lateinit var tasks: List<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the LinearLayout where the task items will be added
        taskListLayout = findViewById(R.id.llTaskList)

        // Sample task data
        tasks = listOf(
            Task(1, "Complete Homework", "Finish the Android assignment by tomorrow."),
            Task(2, "Buy Groceries", "Purchase vegetables and fruits for the week."),
            Task(3, "Team Meeting", "Attend the team meeting at 3 PM.")
        )

        // Populate the LinearLayout with task items
        for (task in tasks) {
            val taskItemView = LayoutInflater.from(this).inflate(R.layout.task_item, taskListLayout, false)

            val taskNameTextView: TextView = taskItemView.findViewById(R.id.tvTaskName)
            val taskDescriptionTextView: TextView = taskItemView.findViewById(R.id.tvTaskDescription)

            taskNameTextView.text = task.name
            taskDescriptionTextView.text = task.description

            taskListLayout.addView(taskItemView)
        }
    }
}
