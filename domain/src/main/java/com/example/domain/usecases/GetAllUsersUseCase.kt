package com.example.domain.usecases

import com.example.domain.models.UsersListModelItemDomain
import com.example.domain.repository.UsersRepository

class GetAllUsersUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(): List<UsersListModelItemDomain> {
        return  repository.getAllUsers()
    }

}