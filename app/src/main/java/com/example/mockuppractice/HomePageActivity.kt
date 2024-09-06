package com.example.mockuppractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class HomePageActivity : AppCompatActivity() {

    private lateinit var btnCerrarSesion: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)

        cerrarSesion()
    }

    private fun cerrarSesion() {
        btnCerrarSesion.setOnClickListener {
            FirebaseAuth.getInstance().signOut()

            val intentLoginReturn = Intent(this, MainActivity::class.java)
            startActivity(intentLoginReturn)

            finish()
        }
    }
}