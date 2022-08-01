package com.example.roomdatabasefirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomdatabasefirst.adapter.UserAdapter
import com.example.roomdatabasefirst.database.entity.AppDatabase
import com.example.roomdatabasefirst.database.entity.User
import com.example.roomdatabasefirst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase
    lateinit var binding: ActivityMainBinding
    private var userList = mutableListOf<User>()
    lateinit var adapter:UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this, AppDatabase::class.java, "tops-student"
        ).allowMainThreadQueries().build()

        adapter = UserAdapter(this, userList)
        binding.recyclerItem.layoutManager = LinearLayoutManager(this)
        binding.recyclerItem.adapter = adapter


        binding.btnAdd.setOnClickListener {
            // navigate to useractivity
            startActivity(Intent(applicationContext, UserActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        if(db!=null){

            userList = db.userDao().getUserList() as MutableList<User>
            adapter.setItems(userList)

        }

    }

}