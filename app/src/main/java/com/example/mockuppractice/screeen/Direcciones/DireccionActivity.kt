package com.example.mockuppractice.screeen.Direcciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.R
import com.example.mockuppractice.screeen.CategoriasActivity

class DireccionActivity : CategoriasActivity() {

    private lateinit var btnAddAdrs: Button
    private lateinit var btnShowAdrs: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_direccion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnShowAdrs = findViewById(R.id.btnShowAddress)
        btnAddAdrs = findViewById(R.id.btnAddAddress)
        NavigationBottomNav(R.id.address)
        changeScreen()
    }

    private fun changeScreen() {
        btnShowAdrs.setOnClickListener {
            val intentShow = Intent(this, ShowDireccionActivity::class.java)
            startActivity(intentShow)
        }

        btnAddAdrs.setOnClickListener {
            val intentAdd = Intent(this, AddDireccionActivity::class.java)
            startActivity(intentAdd)
        }

    }

}