package com.quynhlm.dev.furnitureapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.quynhlm.dev.furnitureapp.entity.User

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User): Long

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    suspend fun login(email: String, password: String): User?
}
