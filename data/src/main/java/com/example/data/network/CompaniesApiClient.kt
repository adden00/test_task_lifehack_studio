package com.example.data.network

import com.example.data.models.CompanyModelItemData
import com.example.data.models.CompaniesListModelItemData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CompaniesApiClient {
    @GET("test.php")
    suspend fun getCompanies(): Response<List<CompaniesListModelItemData>>

    @GET("test.php")
    suspend fun getCompany(
        @Query("id") id: String
    ): Response<List<CompanyModelItemData>>
}