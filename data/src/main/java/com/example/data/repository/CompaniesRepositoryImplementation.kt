package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.CompaniesApiService
import com.example.domain.models.CompanyModelItem
import com.example.domain.models.CompanyListModelItem
import com.example.domain.repository.CompaniesRepository

class CompaniesRepositoryImplementation(private val networkService: CompaniesApiService) :
    CompaniesRepository {
    override suspend fun getAllCompanies(): List<CompanyListModelItem> {
        return networkService.getAllCompanies().map { it.toDomain() }
    }

    override suspend fun getCompany(id: String): CompanyModelItem? {
        return networkService.getCompany(id)?.toDomain()
    }
}