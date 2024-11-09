package com.example.letstodotask

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import missing.namespace.R

class AddTaskActivity : AppCompatActivity() {

    private lateinit var taskNameEditText: EditText
    private lateinit var taskDescriptionEditText: EditText
    private lateinit var taskDeadlineTextView: TextView
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)  // Use your layout file here

        // Initialize views by linking them to the layoutD
        taskNameEditText = findViewById(R.id.et_task_name)
        taskDescriptionEditText = findViewById(R.id.et_task_description)
        taskDeadlineTextView = findViewById(R.id.tv_task_deadline)
        submitButton = findViewById(R.id.btn_submit_task)

        // Set a click listener for the Submit button
        submitButton.setOnClickListener {
            // Logic to save task into SQLite Database
            val taskName = taskNameEditText.text.toString()
            val taskDescription = taskDescriptionEditText.text.toString()
            val taskDeadline = taskDeadlineTextView.text.toString()

            // You can add the logic to save the task to the database or pass it to another activity here
            saveTaskToDatabase(taskName, taskDescription, taskDeadline)
        }
    }

    // Example function to save the task (you'll need to implement the actual saving logic)
    private fun saveTaskToDatabase(name: String, description: String, deadline: String) {
        // Logic to save the task to the database (e.g., SQLite or Room)
        // For now, just logging or using Toast to simulate saving.
        println("Task saved: Name=$name, Description=$description, Deadline=$deadline")
    }
}
