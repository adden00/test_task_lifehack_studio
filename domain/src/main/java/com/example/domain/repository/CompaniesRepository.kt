package com.example.domain.repository

import com.example.domain.models.CompanyModelItem
import com.example.domain.models.CompanyListModelItem

interface CompaniesRepository {
    suspend fun getAllCompanies(): List<CompanyListModelItem>
    suspend fun getCompany(id: String): CompanyModelItem?
}