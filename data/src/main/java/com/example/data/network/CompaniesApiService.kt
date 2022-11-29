package com.example.data.network

import com.example.data.models.CompanyModelItemData
import com.example.data.models.CompaniesListModelItemData

class CompaniesApiService(private val api: CompaniesApiClient) {

    suspend fun getAllCompanies(): List<CompaniesListModelItemData> {
        var result: List<CompaniesListModelItemData>? = null
        try {
            result = api.getCompanies().body()

        } catch (e: Exception) {
        }
        return result ?: listOf()
    }

    suspend fun getCompany(id: String): CompanyModelItemData? {
        var result: CompanyModelItemData? = null
        try {
            result = api.getCompany(id).body()?.get(0)

        } catch (e: Exception) {
        }
        return result
    }
}