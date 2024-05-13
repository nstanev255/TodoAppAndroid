package com.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todoapp.fragment.TodoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_list_host)

        if(savedInstanceState == null) {
            val fragment = TodoListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_content, fragment)
                .commit()
        }
    }
}