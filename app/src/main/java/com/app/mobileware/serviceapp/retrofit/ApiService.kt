package com.app.mobileware.serviceapp.retrofit

import retrofit2.http.GET

interface ApiService {

    @GET("jokes/categories")
    suspend fun getCategories(): List<String>
}