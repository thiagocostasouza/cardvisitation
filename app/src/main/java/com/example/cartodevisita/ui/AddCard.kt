package com.example.cartodevisita.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cartodevisita.App
import com.example.cartodevisita.R
import com.example.cartodevisita.data.CartaoDeVisita
import com.example.cartodevisita.databinding.ActivityAddCardBinding

class AddCard : AppCompatActivity() {
    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners(){
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirmar.setOnClickListener {
            val cartaoDeVisita =  CartaoDeVisita(
                nome = binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                background = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(cartaoDeVisita)
            Toast.makeText(this,R.string.label_show_success, Toast.LENGTH_SHORT).show()
        }

    }
}