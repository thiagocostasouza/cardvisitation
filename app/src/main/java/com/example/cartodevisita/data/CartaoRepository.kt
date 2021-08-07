package com.example.cartodevisita.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoRepository(private val dao: CartaoDao){

    fun insert(cartaoDeVisita: CartaoDeVisita) = runBlocking {
        launch (Dispatchers.IO){
           dao.insert(cartaoDeVisita)
        }
    }

    fun getAll() = dao.getAll()
}


