package com.example.uniquelux

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

//Class untuk urusin database
val DATABASE_NAME: String = "dbUniqueLux"
val TABLE_NAME:String = "Users"
val COL_ID: String = "id"
val COL_EMAIL: String = "email"
val COL_USERNAME: String = "username"
val COL_PASSWORD: String = "password"

class DBHelper(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable: String = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
                ", $COL_EMAIL VARCHAR(255) NOT NULL, $COL_USERNAME VARCHAR(255) NOT NULL, $COL_PASSWORD VARCHAR(25) NOT NULL," +
                "CONSTRAINT uniqueEmail UNIQUE($COL_EMAIL))"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_EMAIL, user.email)
        cv.put(COL_USERNAME, user.username)
        cv.put(COL_PASSWORD, user.password)

        var result = db.insert(TABLE_NAME, null, cv)

        if(result == -1.toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Registered Succesfully.", Toast.LENGTH_SHORT).show()
        }
        db.close()
    }

    //fungsi cek data
    //parameter user yg di sini adalah objUser di LoginPage1.kt
    fun dataIsTrue(user: User): Boolean {
        val db = this.readableDatabase
        val query = "SELECT $COL_USERNAME, $COL_PASSWORD FROM $TABLE_NAME WHERE $COL_USERNAME = '${user.username}'"
        var result = db.rawQuery(query, null)

        if (result.moveToFirst()) {
            val fetchedUser = User()
            fetchedUser.username = result.getString(result.getColumnIndex(COL_USERNAME))
            fetchedUser.password = result.getString(result.getColumnIndex(COL_PASSWORD))

            result.close()
            db.close()
            return fetchedUser.username == user.username && fetchedUser.password == user.password
        }

        else {
            result.close()
            db.close()
            return false
        }
    }

    fun deleteAllData() {
        val db = this.writableDatabase

        var x = 1

        while(x < 15){
            db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(1.toString()))
            x++
        }

        db.close()
//        Toast.makeText(context,"${COL_ID}+=?    ${arrayOf(1.toString())}", Toast.LENGTH_SHORT).show()
    }

//    fun dropTable() {
//        val db = this.writableDatabase
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
//        db.close()
//    }
//
//    fun createTable() {
//        val db = this.writableDatabase
//        val createTable: String = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
//                ", $COL_EMAIL VARCHAR(255) NOT NULL, $COL_USERNAME VARCHAR(255) NOT NULL, $COL_PASSWORD VARCHAR(25) NOT NULL," +
//                "CONSTRAINT uniqueEmail UNIQUE($COL_EMAIL))"
//
//        db.execSQL(createTable)
//    }
}