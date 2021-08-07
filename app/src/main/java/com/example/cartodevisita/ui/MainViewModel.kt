package com.example.cartodevisita.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartodevisita.data.CartaoDeVisita
import com.example.cartodevisita.data.CartaoRepository
import java.lang.IllegalArgumentException

class MainViewModel(private val cartaoRepository: CartaoRepository) : ViewModel() {

    fun insert(cartaoDeVisita: CartaoDeVisita){
            cartaoRepository.insert(cartaoDeVisita)
    }

    fun getAll(): LiveData<List<CartaoDeVisita>>{
        return cartaoRepository.getAll()
    }

}

class MainViewModelFactory(private val repository: CartaoRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(repository) as T
    }
            throw IllegalArgumentException("Unknown ViewModel class")
    }
}