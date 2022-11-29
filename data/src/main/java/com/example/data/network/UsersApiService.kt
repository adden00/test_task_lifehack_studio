package com.example.data.network

import com.example.data.models.UserModelItem
import com.example.data.models.UsersListModelItem

class UsersApiService(private val api: UsersApiClient) {

    suspend fun getAllUsers(): List<UsersListModelItem> {
        var result: List<UsersListModelItem>? = null
        try {
            result = api.getUsers().body()

        }
        catch (e: Exception) {}
        return result ?: listOf()
    }

    suspend fun getUser(id: Int): UserModelItem? {
        var result: UserModelItem? = null
        try {
            result = api.getUser(id).body()

        }
        catch (e: Exception) {}
        return result
    }

}