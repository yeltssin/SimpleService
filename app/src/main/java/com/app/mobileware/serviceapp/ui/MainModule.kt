package com.app.mobileware.serviceapp.ui

import com.app.mobileware.serviceapp.Retrofit
import com.app.mobileware.serviceapp.data.ServiceGateway
import com.app.mobileware.serviceapp.data.ServiceGatewayImpl
import org.koin.dsl.module
import retrofit2.create

val mainModule = module {
    scope<MainActivity> {

        scoped<ServiceGateway> {
            ServiceGatewayImpl(
                apiService = get<Retrofit>().getRetrofit().create()
            )
        }

        scoped<MainViewModel> {
            MainViewModel(
                serviceGateway = get()
            )
        }

    }

}