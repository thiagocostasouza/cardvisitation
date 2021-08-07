package com.example.cartodevisita.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CartaoDao {

    @Query("SELECT * FROM CartaoDeVisita")
    fun getAll(): LiveData<List<CartaoDeVisita>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  insert(cartaoDeVisita: CartaoDeVisita)

}