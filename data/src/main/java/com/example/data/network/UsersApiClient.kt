package com.example.data.network

import com.example.data.models.UserModelItem
import com.example.data.models.UsersListModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApiClient {
    @GET ("test.php")
    suspend fun getUsers(): Response<List<UsersListModelItem>>

    @GET ("test.php")
    suspend fun getUser(
        @Query ("id") id: Int
    ): Response<UserModelItem>

}