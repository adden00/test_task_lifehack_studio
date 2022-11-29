package com.example.domain.usecases

import com.example.domain.models.CompanyModelItem
import com.example.domain.repository.CompaniesRepository

class GetCompanyUseCase(private val repository: CompaniesRepository) {

    suspend operator fun invoke(id: String): CompanyModelItem? {
        return repository.getCompany(id)
    }
}