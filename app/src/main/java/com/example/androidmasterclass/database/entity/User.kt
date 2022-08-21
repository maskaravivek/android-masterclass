package com.example.androidmasterclass.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val email: String,
    @ColumnInfo(defaultValue = "0") val age: Int,
    @ColumnInfo(defaultValue = "NA") val address: String
)