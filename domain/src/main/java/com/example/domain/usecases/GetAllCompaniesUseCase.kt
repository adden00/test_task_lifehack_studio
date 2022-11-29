package com.example.domain.usecases

import com.example.domain.models.CompanyListModelItem
import com.example.domain.repository.CompaniesRepository

class GetAllCompaniesUseCase(private val repository: CompaniesRepository) {

    suspend operator fun invoke(): List<CompanyListModelItem> {
        return repository.getAllCompanies()
    }
}