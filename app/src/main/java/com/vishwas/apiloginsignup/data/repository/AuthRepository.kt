package com.vishwas.apiloginsignup.data.repository

import com.vishwas.apiloginsignup.data.network.AuthApi

class AuthRepository(private val api:AuthApi) :BaseRepository(){


   suspend fun login(email: String, password:String)=safeApisCall { api.login( email,password) }

}