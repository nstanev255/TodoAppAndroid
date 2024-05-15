package com.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.todoapp.R
import com.todoapp.Todo
import com.todoapp.TodoAdapter
import com.todoapp.databinding.TodoListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TodoListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
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
            fabAddTodo.setOnClickListener {
                Navigation.findNavController(view).navigate(R.id.navigateToNewTodoItem)
            }
        }

    }
}