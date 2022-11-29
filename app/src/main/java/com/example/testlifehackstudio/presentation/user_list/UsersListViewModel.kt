package com.example.testlifehackstudio.presentation.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UsersListModelItemDomain
import com.example.domain.usecases.GetAllUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(private val getAllUsersUseCase: GetAllUsersUseCase): ViewModel() {

    private val _usersList = MutableStateFlow(listOf<UsersListModelItemDomain>())
    val usersList: StateFlow<List<UsersListModelItemDomain>> = _usersList.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadAllUsers()
    }

    private fun loadAllUsers() {
        _isLoading.value = true
        viewModelScope.launch {
            val result = getAllUsersUseCase()
            _usersList.value = result
            _isLoading.value = false
        }
    }


}