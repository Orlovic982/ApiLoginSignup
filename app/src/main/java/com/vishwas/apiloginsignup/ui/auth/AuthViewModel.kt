package com.vishwas.apiloginsignup.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishwas.apiloginsignup.data.network.Resources
import com.vishwas.apiloginsignup.data.repository.AuthRepository
import com.vishwas.apiloginsignup.data.responses.LoginResponse
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resources<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resources<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)


    }
}