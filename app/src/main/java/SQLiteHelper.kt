package com.example.letstodo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, "tasks.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """CREATE TABLE tasks (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            description TEXT,
            deadline TEXT,
            completed INTEGER DEFAULT 0
        )"""
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS tasks")
        onCreate(db)
    }

    fun addTask(name: String, description: String, deadline: String) {
        val values = ContentValues().apply {
            put("name", name)
            put("description", description)
            put("deadline", deadline)
            put("completed", 0)
        }
        writableDatabase.insert("tasks", null, values)
    }

    fun markTaskCompleted(id: Int) {
        val values = ContentValues().apply { put("completed", 1) }
        writableDatabase.update("tasks", values, "id=?", arrayOf(id.toString()))
    }

    // Additional functions for retrieving, editing, and deleting tasks
}
