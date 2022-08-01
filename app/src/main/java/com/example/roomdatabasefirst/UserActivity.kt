package com.example.roomdatabasefirst

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.roomdatabasefirst.database.entity.AppDatabase
import com.example.roomdatabasefirst.database.entity.User
import com.example.roomdatabasefirst.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    lateinit var db: AppDatabase
    lateinit var binding: ActivityUserBinding
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this, AppDatabase::class.java, "tops-student"
        ).allowMainThreadQueries().build()

        user = intent.getParcelableExtra("USER")

        if(user!=null){
            binding.btnAdd.text= "Update"

            user?.let {
                binding.etName.setText(it.name)
                binding.etEmail.setText(it.email)
                binding.etContact.setText(it.contact)
            }

        }


        binding.btnAdd.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()

            addRecord(name, email, contact)

        }

    }

    private fun addRecord(name: String, email: String, contact: String) {

        var user = User(email = email, name = name, contact = contact)
        try {
            db.userDao().insertRecord(user)

            Toast.makeText(applicationContext, "Record added sucessfully", Toast.LENGTH_SHORT)
                .show()
            binding.etContact.setText("")
            binding.etName.setText("")
            binding.etEmail.setText("")

            onBackPressed()

        } catch (e: Exception) {

        }

    }
}