package com.example.letstodotask

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import missing.namespace.R

class HomeActivity : AppCompatActivity(), TaskAdapter.TaskClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private var tasks = mutableListOf<Task>()  // List to hold tasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize the RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data to populate tasks (you should ideally get this from a database)
        tasks.add(Task(1, "Complete Homework", "Finish the assignment for Android Development.", "2024-11-10 12:00"))
        tasks.add(Task(2, "Grocery Shopping", "Buy vegetables and fruits.", "2024-11-12 14:00"))

        // Initialize the adapter and set it to RecyclerView
        taskAdapter = TaskAdapter(tasks, this)
        recyclerView.adapter = taskAdapter

        // Floating Action Button to navigate to AddTaskActivity
        val fabAddTask: FloatingActionButton = findViewById(R.id.fabAddTask)
        fabAddTask.setOnClickListener {
            // Start the Add Task Activity
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onTaskComplete(task: Task) {
        // Mark the task as completed
        Toast.makeText(this, "Task '${task.name}' marked as completed!", Toast.LENGTH_SHORT).show()
        tasks.remove(task)
        taskAdapter.notifyDataSetChanged()  // Update RecyclerView
    }

    override fun onTaskEdit(task: Task) {
        // Start the Edit Task activity (you should implement this)
        Toast.makeText(this, "Editing task '${task.name}'", Toast.LENGTH_SHORT).show()
        // For now, we'll show a simple message.
    }

    override fun onTaskDelete(task: Task) {
        // Delete the task from the list
        tasks.remove(task)
        taskAdapter.notifyDataSetChanged()  // Update RecyclerView
        Toast.makeText(this, "Task '${task.name}' deleted.", Toast.LENGTH_SHORT).show()
    }
}
