package com.example.mockuppractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var btnRegister: Button
    private lateinit var edEmailRegister: EditText
    private lateinit var edPwdRegister: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnRegister = findViewById(R.id.btnRegister)
        edEmailRegister = findViewById(R.id.edUsernameRegister)
        edPwdRegister = findViewById(R.id.edPasswordRegister)

        val tvRegisterPage = findViewById<TextView>(R.id.tvLogin)
        tvRegisterPage.setOnClickListener { loginPage() }

        register()

    }

    private fun register() {
        title = "Register"
        btnRegister.setOnClickListener {
            if (edEmailRegister.text.isNotEmpty() && edPwdRegister.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    edEmailRegister.text.toString(),
                    edPwdRegister.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        loginPage()
                        finish()
                    } else {
                        Toast.makeText(this, "Error autenticando usuario", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }
        }
    }

    private fun loginPage() {
        val intentPageLogin = Intent(this, MainActivity::class.java)
        startActivity(intentPageLogin)
        finish()
    }
}