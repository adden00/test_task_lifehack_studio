package com.example.testlifehackstudio.presentation.company_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.CompanyModelItem
import com.example.domain.usecases.GetCompanyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(private val getCompanyUseCase: GetCompanyUseCase) :
    ViewModel() {

    private val _companyInfo: MutableStateFlow<CompanyModelItem?> = MutableStateFlow(null)
    val companyInfo: StateFlow<CompanyModelItem?> = _companyInfo.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadCompanyInfo(id: String) {
        _isLoading.value = true
        _companyInfo.value = null
        viewModelScope.launch {
            val result = getCompanyUseCase(id)
            _companyInfo.value = result
            _isLoading.value = false
        }
    }
}