package com.example.roomdatabasefirst.database.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabasefirst.database.entity.dao.UserDAO

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun userDao() : UserDAO

}