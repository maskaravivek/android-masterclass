package com.example.androidmasterclass.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.androidmasterclass.database.entity.User

@Dao
interface UserDao {
    @Insert(onConflict = REPLACE)
    suspend fun insert(user: User)

    @Insert
    suspend fun insertMultiple(vararg users: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Delete
    suspend fun deleteMultiple(vararg users: User)

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user where email=:email limit 1")
    suspend fun getByEmailId(email: String): User
}