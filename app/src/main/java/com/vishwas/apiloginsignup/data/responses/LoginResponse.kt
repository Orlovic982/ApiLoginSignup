package com.vishwas.apiloginsignup.data.responses

data class LoginResponse(
    val access_token: String,
    val user: User
)