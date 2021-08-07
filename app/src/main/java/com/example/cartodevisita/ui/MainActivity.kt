package com.example.cartodevisita.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cartodevisita.App
import com.example.cartodevisita.databinding.ActivityMainBinding
import com.example.cartodevisita.util.Image

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter by lazy { CartaoAdapter() }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCartoes.adapter = adapter
        getAllCartoes()
        insertListeners()
    }


    private fun insertListeners() {
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddCard::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = {cartao ->
            Image.share(this@MainActivity, cartao)
        }
    }

    private fun getAllCartoes() {
        mainViewModel.getAll().observe(this, { cartaoDeVisita ->
                adapter.submitList(cartaoDeVisita)
        })

    }
}