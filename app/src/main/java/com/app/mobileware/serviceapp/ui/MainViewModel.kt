package com.app.mobileware.serviceapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mobileware.serviceapp.data.ServiceGateway
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val serviceGateway: ServiceGateway) : ViewModel() {


    private val _showLoading = MutableStateFlow(false)
    val showLoading = _showLoading.asStateFlow()

    private val _success = MutableSharedFlow<List<String>>()
    val success = _success.asSharedFlow()

    private val _showError = MutableSharedFlow<String>()
    val showError = _showError.asSharedFlow()

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            serviceGateway.getCategories().success {
                println("servicios succes ${it.data.toList()}")
                _success.emit(it.data.toList())
            }.failure {
                _showError.emit(it.toString())
            }
        }
    }

}