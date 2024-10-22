package com.app.mobileware.serviceapp.data

import com.app.mobileware.serviceapp.retrofit.ApiService
import com.app.mobileware.serviceapp.utils.Results

class ServiceGatewayImpl(private val apiService: ApiService) : ServiceGateway {


    override suspend fun getCategories(): Results<List<String>> {
        try {
            return Results.Success(apiService.getCategories())
        } catch (e: Exception) {
            return Results.Failure(e)
        }
    }
}