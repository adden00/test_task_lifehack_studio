package com.example.testlifehackstudio.common.di

import com.example.domain.repository.CompaniesRepository
import com.example.domain.usecases.GetAllCompaniesUseCase
import com.example.domain.usecases.GetCompanyUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetAllUseCase(repository: CompaniesRepository): GetAllCompaniesUseCase =
        GetAllCompaniesUseCase(repository)

    @Provides
    fun provideGetCompanyUseCase(repository: CompaniesRepository): GetCompanyUseCase =
        GetCompanyUseCase(repository)
}