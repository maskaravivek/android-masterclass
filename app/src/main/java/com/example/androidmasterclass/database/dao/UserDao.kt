package com.example.androidmasterclass.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.androidmasterclass.database.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    fun insertMultiple(vararg users: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteMultiple(vararg users: User)

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user where email=:email")
    fun getByEmailId(email: String): List<User>
}