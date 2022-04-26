package com.vishwas.apiloginsignup.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vishwas.apiloginsignup.data.repository.AuthRepository
import com.vishwas.apiloginsignup.data.repository.BaseRepository
import com.vishwas.apiloginsignup.ui.auth.AuthViewModel
import java.lang.IllegalArgumentException
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: BaseRepository) :ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(AuthViewModel::class.java)->AuthViewModel(repository as AuthRepository) as T
            else->throw  IllegalArgumentException("ViewModel class Not Found")
        }
    }


}