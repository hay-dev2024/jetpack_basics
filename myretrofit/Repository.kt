package com.example.myretrofit

class UserRepository {
    suspend fun getUsers(): List<User> {
        return RetrofitInstance.api.getUsers()
    }
}