package com.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.todoapp.Todo
import com.todoapp.TodoAdapter
import com.todoapp.databinding.TodoListBinding

class TodoListFragment : Fragment() {
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var binding: TodoListBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding =TodoListBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        todoAdapter = TodoAdapter(mutableListOf())

        binding.rvTodoItems.adapter = todoAdapter
        binding.rvTodoItems.layoutManager = LinearLayoutManager(view.context)

        binding.apply {

            btnAddTodo.setOnClickListener {
                val text = etTodoTitle.text.toString()
                if(text.isNotEmpty()) {
                    val todoItem = Todo(text)
                    todoAdapter.addTodo(todoItem)

                    etTodoTitle.text.clear()
                }
            }

            btnDeleteDoneTodos.setOnClickListener {
                todoAdapter.deleteDoneTodos()
            }
        }

    }
}