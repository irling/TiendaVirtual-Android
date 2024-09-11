package com.example.mockuppractice

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.screeen.CategoriasActivity
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private lateinit var btnLogin: Button
    private lateinit var edEmaiLogin: EditText
    private lateinit var edPwdLogin: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //FIREBASE ANALYTICS
        firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        bundle.putString("message", "Integracion de firebase")
        firebaseAnalytics.logEvent("InitScreen", bundle)

        //DECLARACION DE VARIABLES
        val tvRegisterPage = findViewById<TextView>(R.id.tvRegister)
        tvRegisterPage.setOnClickListener { registerPage() }

        btnLogin = findViewById(R.id.btnLogin)
        edEmaiLogin = findViewById(R.id.edUsername)
        edPwdLogin = findViewById(R.id.edPassword)

        Login()

    }

    private fun Login() {
        title = "Register"
        btnLogin.setOnClickListener {
            if (edEmaiLogin.text.isNotEmpty() && edPwdLogin.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    edEmaiLogin.text.toString(),
                    edPwdLogin.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        HomePage()
                        Toast.makeText(this, "Sesión iniciada", Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        Toast.makeText(this, "Error autenticando usuario", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    private fun HomePage() {
        val intentHomePage = Intent(this, CategoriasActivity::class.java)
        startActivity(intentHomePage)
    }


    private fun registerPage() {
        val intentRegisterPage = Intent(this, RegisterActivity::class.java)
        startActivity(intentRegisterPage)
        finish()
        //Toast.makeText(this, "Texto clicado de register", Toast.LENGTH_SHORT).show()
    }

}