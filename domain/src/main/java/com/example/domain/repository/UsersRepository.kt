package com.example.domain.repository

import com.example.domain.models.UserModelItemDomain
import com.example.domain.models.UsersListModelItemDomain

interface UsersRepository {

    suspend fun getAllUsers(): List<UsersListModelItemDomain>

    suspend fun getUser(id: Int): UserModelItemDomain?


}