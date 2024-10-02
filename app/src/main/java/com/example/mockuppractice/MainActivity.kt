package com.example.mockuppractice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.databinding.ActivityMainBinding
import com.example.mockuppractice.screeen.CategoriasActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private lateinit var btnLogin: Button
    private lateinit var edEmaiLogin: EditText
    private lateinit var edPwdLogin: EditText

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Google Sign in
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // FIREBASE ANALYTICS
        firebaseAnalytics = Firebase.analytics
        val bundle = Bundle()
        bundle.putString("message", "Integracion de firebase")
        firebaseAnalytics.logEvent("InitScreen", bundle)

        // Firebase Autentication
        auth = Firebase.auth

        // DECLARACION DE VARIABLES
        val tvRegisterPage = findViewById<TextView>(R.id.tvRegister)
        tvRegisterPage.setOnClickListener { registerPage() }

        btnLogin = findViewById(R.id.btnLogin)
        edEmaiLogin = findViewById(R.id.edUsername)
        edPwdLogin = findViewById(R.id.edPassword)

        Login()

        binding?.btnLoginGoogle?.setOnClickListener{
            signInWithGoogle()
        }

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

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                handleResults(task)
            }
        }

    private fun handleResults(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if (account != null) {
                updateUI(account)
            }
        } else {
            Toast.makeText(this, "Inicio de sesión fallido, probar despues.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener {
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

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
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