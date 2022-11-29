package com.example.testlifehackstudio.common.di

import com.example.data.network.UsersApiClient
import com.example.data.network.UsersApiService
import com.example.data.repository.UsersRepositoryImplementation
import com.example.domain.repository.UsersRepository
import com.example.testlifehackstudio.common.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideApiClient(): UsersApiClient {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(UsersApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkService(api: UsersApiClient) = UsersApiService(api)

    @Provides
    @Singleton
    fun provideUsersRepo(networkService: UsersApiService): UsersRepository {
        return UsersRepositoryImplementation(networkService)
    }


}