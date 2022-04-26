package com.vishwas.apiloginsignup.data.responses

data class User(
    val created_at: String,
    val email: String,
    val email_verified_at: Any,
    val first_name: String,
    val id: Int,
    val image_url: String,
    val last_name: String,
    val updated_at: String
)