package com.vishwas.apiloginsignup.data.network

import com.vishwas.apiloginsignup.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("/api/login")
    suspend fun login (
        @Field("email")
        email:String,
        @Field("password")
        password:String
    ):LoginResponse


}