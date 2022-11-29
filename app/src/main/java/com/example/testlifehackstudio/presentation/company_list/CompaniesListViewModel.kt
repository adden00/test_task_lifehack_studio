package com.example.testlifehackstudio.presentation.company_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CompanyListModelItem
import com.example.domain.usecases.GetAllCompaniesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompaniesListViewModel @Inject constructor(private val getAllCompaniesUseCase: GetAllCompaniesUseCase) :
    ViewModel() {
    private val _companiesList = MutableStateFlow(listOf<CompanyListModelItem>())
    val companiesList: StateFlow<List<CompanyListModelItem>> = _companiesList.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadAllCompanies()
    }

    fun loadAllCompanies() {
        _isLoading.value = true
        viewModelScope.launch {
            val result = getAllCompaniesUseCase()
            _companiesList.value = result
            _isLoading.value = false
        }
    }
}