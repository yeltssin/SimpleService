package com.app.mobileware.serviceapp.di

import com.app.mobileware.serviceapp.Retrofit
import org.koin.dsl.module


val baseModule = module {
    single { Retrofit(get()) }
}