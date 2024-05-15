package com.todoapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.todoapp.R
import com.todoapp.databinding.FragmentAddNewTodoItemBinding

class AddNewTodoItemFragment : Fragment() {

    private lateinit var binding: FragmentAddNewTodoItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNewTodoItemBinding.inflate(inflater);

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var backBtn = binding.floatingActionButton;
        backBtn.setOnClickListener {
            Navigation.findNavController(view).navigateUp()
        }
    }
}