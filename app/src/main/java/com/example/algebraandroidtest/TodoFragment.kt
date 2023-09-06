package com.example.algebraandroidtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodoFragment : Fragment() {

    private lateinit var todoTitle: EditText
    private lateinit var todoDescription: EditText
    private lateinit var addTodo: Button

    var todosList = mutableListOf<Todo>()
    private val todoAdapter = TodoAdapter(todosList)
    private lateinit var todosRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.let {
            todoTitle = it.findViewById(R.id.todoTitle_et)
            todoDescription = it.findViewById(R.id.todoDescription_et)
            addTodo = it.findViewById(R.id.addTodo_btn)
            todosRecyclerView = it.findViewById(R.id.todo_recyclerView)
            todosRecyclerView.adapter = todoAdapter
            todosRecyclerView.layoutManager = LinearLayoutManager(context)
        }

        addTodo.setOnClickListener {
            if (todoTitle.text.isEmpty() && todoDescription.text.isEmpty()) {
                todoTitle.error = "Please enter todo title"
                todoDescription.error = "Please enter todo description"

            } else if (todoTitle.text.isEmpty()) {
                todoTitle.error = "Please enter todo title"

            } else if (todoDescription.text.isEmpty()) {
                todoDescription.error = "Please enter todo description"

            } else {
                val title = todoTitle.text.toString()
                val description = todoDescription.text.toString()
                val todoTask = Todo(title, description)

                todosList.add(todoTask)
                todoAdapter.notifyItemInserted(todosList.size - 1)

                todoTitle.setText("")
                todoDescription.setText("")
            }
        }
    }

}