package com.example.algebraandroidtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(var todos: MutableList<Todo>) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.apply {
            todoTitle.text = todos[position].title
            todoDescription.text = todos[position].description
        }
    }

    //TODO Implement deleteItemFromList function
    fun deleteItemFromList(holder: TodoViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            todos.removeAt(position)
        }
    }
}

class TodoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    val todoTitle: TextView = itemView.findViewById(R.id.displayTodoTitle_tv)
    val todoDescription: TextView = itemView.findViewById(R.id.displayTodoDescription_tv)
}