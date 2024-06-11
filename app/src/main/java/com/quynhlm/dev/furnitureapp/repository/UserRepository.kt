package com.quynhlm.dev.furnitureapp.repository

import android.content.Context
import com.quynhlm.dev.furnitureapp.database.AppDatabase
import com.quynhlm.dev.furnitureapp.entity.User

class UserRepository(context: Context) {
    private val db = AppDatabase.getDatabase(context)
    private val userDao = db.userDao()

    suspend fun registerUser(user: User): Long {
        return userDao.insertUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.login(email, password)
    }
}
