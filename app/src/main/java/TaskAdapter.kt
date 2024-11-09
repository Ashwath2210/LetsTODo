package com.example.letstodotask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import missing.namespace.R

class TaskAdapter(
    private val tasks: List<Task>,
    private val listener: TaskClickListener
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskNameTextView: TextView = itemView.findViewById(R.id.tvTaskName)
        private val taskDescriptionTextView: TextView = itemView.findViewById(R.id.tvTaskDescription)
        private val completeButton: Button = itemView.findViewById(R.id.btnComplete)
        private val editButton: Button = itemView.findViewById(R.id.btnEdit)
        private val deleteButton: Button = itemView.findViewById(R.id.btnDelete)

        fun bind(task: Task) {
            taskNameTextView.text = task.name
            taskDescriptionTextView.text = task.description

            completeButton.setOnClickListener {
                listener.onTaskComplete(task)
            }

            editButton.setOnClickListener {
                listener.onTaskEdit(task)
            }

            deleteButton.setOnClickListener {
                listener.onTaskDelete(task)
            }
        }
    }

    interface TaskClickListener {
        fun onTaskComplete(task: Task)
        fun onTaskEdit(task: Task)
        fun onTaskDelete(task: Task)
    }
}
