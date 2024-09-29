package com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.R
import com.google.android.gms.wallet.PaymentsClient

class Shirt01 : AppCompatActivity() {

    private lateinit var btnNext: ImageButton
    private lateinit var btnBack: ImageButton

    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shirt01)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        changePage()

    }

    private fun initComponents() {
        btnNext = findViewById(R.id.ibtnDerecha)
        btnBack = findViewById(R.id.ibtnIzquierda)
        btnSave = findViewById(R.id.btnSave01)
    }

    private fun changePage() {
        btnNext.setOnClickListener {
            val intentNext = Intent(this, Shirt02::class.java)
            startActivity(intentNext)
        }
        btnBack.setOnClickListener {
            Toast.makeText(this, "No hay más productos", Toast.LENGTH_SHORT).show()
        }
    }
}