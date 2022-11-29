package com.example.testlifehackstudio.common.di

import com.example.data.network.CompaniesApiClient
import com.example.data.network.CompaniesApiService
import com.example.data.repository.CompaniesRepositoryImplementation
import com.example.domain.repository.CompaniesRepository
import com.example.testlifehackstudio.common.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideApiClient(): CompaniesApiClient {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(CompaniesApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkService(api: CompaniesApiClient) = CompaniesApiService(api)

    @Provides
    @Singleton
    fun provideCompaniesRepo(networkService: CompaniesApiService): CompaniesRepository {
        return CompaniesRepositoryImplementation(networkService)
    }
}