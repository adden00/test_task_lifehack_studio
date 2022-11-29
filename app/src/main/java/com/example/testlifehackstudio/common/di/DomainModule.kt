package com.example.testlifehackstudio.common.di

import com.example.domain.repository.UsersRepository
import com.example.domain.usecases.GetAllUsersUseCase
import com.example.domain.usecases.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn (ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllUseCase(repository: UsersRepository): GetAllUsersUseCase = GetAllUsersUseCase(repository)

    @Provides
    fun provideGetUserUseCase(repository: UsersRepository): GetUserUseCase = GetUserUseCase(repository)
}