package com.example.bottomnavigation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation.databinding.ItemTaskBinding

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var data = arrayListOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addTask(task: Task) {
        data.add(task)
    }

    inner class TaskViewHolder(private var binding: ItemTaskBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.title.text = task.title
            binding.desc.text = task.desc
        }
    }
}