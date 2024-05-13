package com.todoapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.todoapp.databinding.ItemTodoBinding

class TodoAdapter (
    private val todos: MutableList<Todo>,
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    class TodoViewHolder( private val todoBinding: ItemTodoBinding ) : RecyclerView.ViewHolder(todoBinding.root) {

        //TODO: Fix this bug...
        private fun applyStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
            if(isChecked) {
                tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
            } else {
                tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG
            }
        }

        fun bind(currentItem: Todo) {
            todoBinding.apply {
                tvTodoTitle.text = currentItem.title
                checkBox.isChecked = currentItem.isChecked
                applyStrikeThrough(tvTodoTitle, currentItem.isChecked)

                tvTodoTitle.setOnClickListener {
                    Navigation.findNavController(todoBinding.root).navigate(R.id.navigateToDetailFragment)
                }

                checkBox.setOnCheckedChangeListener { _, isChecked ->
                    applyStrikeThrough(tvTodoTitle, isChecked)
                    currentItem.isChecked = !currentItem.isChecked;
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)

        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { todo -> todo.isChecked }

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentItem = todos[position]

        holder.bind(currentItem);
    }

}