package com.quynhlm.dev.furnitureapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quynhlm.dev.furnitureapp.entity.User
import com.quynhlm.dev.furnitureapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun registerUser(name: String, email: String, password: String, onResult: (Long) -> Unit) {
        viewModelScope.launch {
            val result = repository.registerUser(User(name = name, email = email, password = password))
            onResult(result)
        }
    }

    fun loginUser(email: String, password: String, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = repository.loginUser(email, password)
            onResult(user)
        }
    }
}
