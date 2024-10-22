package com.app.mobileware.serviceapp.data

import com.app.mobileware.serviceapp.utils.Results

interface ServiceGateway {
    suspend fun getCategories(): Results<List<String>>
}