package com.example.androidmasterclass.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidmasterclass.database.dao.UserDao
import com.example.androidmasterclass.database.entity.User

@Database(entities = [User::class],
    exportSchema = true,
    autoMigrations = [
        AutoMigration (
            from = 1,
            to = 2
        )
    ],
    version = 2
)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE User ADD COLUMN city STRING")
            }
        }
    }
}