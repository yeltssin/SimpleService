package com.app.mobileware.serviceapp.di

import com.app.mobileware.serviceapp.di.baseModule
import com.app.mobileware.serviceapp.ui.mainModule


val appModule = listOf(
    baseModule,
    mainModule
)