package com.example.roomdatabasefirst.database.entity.dao

import androidx.room.*
import com.example.roomdatabasefirst.database.entity.User

@Dao
interface UserDAO {
    @Insert
    fun insertRecord(user: User)

    @Query("select * from `user-table`")
    fun getUserList():List<User>

    @Query("select * from `user-table` where id = :uid")
    fun getUser(uid:Int) : User

    @Delete
    fun deleteUser(user:User)

    @Update
    fun updateRecord(updatedUser: User)

    /*@Query("delete from `user-table` where id = :id")
    fun deleteRecord(id:Int)*/

}