package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.UsersApiService
import com.example.domain.models.UserModelItemDomain
import com.example.domain.models.UsersListModelItemDomain
import com.example.domain.repository.UsersRepository

class UsersRepositoryImplementation (private val networkService: UsersApiService): UsersRepository {
    override suspend fun getAllUsers(): List<UsersListModelItemDomain> {
        return networkService.getAllUsers().map { it.toDomain() }
    }

    override suspend fun getUser(id: Int): UserModelItemDomain? {
        return networkService.getUser(id)?.toDomain()
    }


}