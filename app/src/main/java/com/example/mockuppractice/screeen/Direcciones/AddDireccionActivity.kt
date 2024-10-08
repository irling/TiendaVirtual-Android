package com.example.mockuppractice.screeen.Direcciones

import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.R
import com.example.mockuppractice.screeen.CategoriasActivity
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class AddDireccionActivity : CategoriasActivity() {

    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_direccion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        SaveDataForm()

    }

    private fun SaveDataForm() {
        val ETdireccion = findViewById<EditText>(R.id.edDireccion)
        val ETnumeroDire = findViewById<EditText>(R.id.edNumeroCasa)
        val ETtipoDomi = findViewById<EditText>(R.id.edTipo)
        val ETreferencia = findViewById<EditText>(R.id.edreferencia)
        val botonSave = findViewById<Button>(R.id.btnGuardarDireccion)

        botonSave.setOnClickListener {
            //se recuperan los ET
            val direccion = ETdireccion.text.toString()
            val numeroDire = ETnumeroDire.text.toString()
            val tipoDomi = ETtipoDomi.text.toString()
            val referencia = ETreferencia.text.toString()

            //validamos si estan los campos vacios (para obligar rellenar)
            if (direccion.isEmpty() || numeroDire.isEmpty() || tipoDomi.isEmpty() || referencia.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT)
                    .show()
            } else {
                //Se envian los datos!!!!!!
                val nuevaDireccion = formDireccion(direccion, numeroDire, tipoDomi, referencia)

                val sharedPreferences = getSharedPreferences("direccionesUsers", MODE_PRIVATE)
                val json = sharedPreferences.getString("Direcciones", "[]")

                val type = object : TypeToken<List<formDireccion>>() {}.type
                val direcciones: MutableList<formDireccion> = gson.fromJson(json, type)

                direcciones.add(nuevaDireccion)

                val editor = sharedPreferences.edit()
                val jsonUpdated = gson.toJson(direcciones)
                editor.putString("Direcciones", jsonUpdated)
                editor.apply()

                Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_SHORT).show()

                finish()

            }

        }

    }

}