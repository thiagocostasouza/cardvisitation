package com.example.cartodevisita

import android.app.Application
import com.example.cartodevisita.data.AppDatabase
import com.example.cartodevisita.data.CartaoRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoRepository(database.cartaoDao()) }
}