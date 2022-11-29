package com.example.domain.usecases

import com.example.domain.models.UserModelItemDomain
import com.example.domain.repository.UsersRepository

class GetUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: Int): UserModelItemDomain? {
        return  repository.getUser(id)
    }
}