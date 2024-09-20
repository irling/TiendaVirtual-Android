package com.example.mockuppractice.screeen.Direcciones

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShowDireccionActivity : AppCompatActivity() {

    private val gson = Gson()

    override fun onStart() {
        super.onStart()
        showDataDirecciones()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_direccion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showDataDirecciones()
    }

    private fun showDataDirecciones() {
        val tvShowDirec = findViewById<TextView>(R.id.tvShowDirecciones)

        val sharedPreferences = getSharedPreferences("DireccionUsers", MODE_PRIVATE)
        val json = sharedPreferences.getString("Direcciones", "[]")

        val type = object : TypeToken<List<formDireccion>>() {}.type
        val direcciones: List<formDireccion> = gson.fromJson(json, type)

        val direccionText = direcciones.joinToString("\n") {
            "Dirección: ${it.direccion}\n Número: ${it.numeroDire}\n Tipo Domicilio: ${it.tipoDomi}\n Referencia: ${it.referencia}"
        }

        tvShowDirec.text = direccionText
    }

}