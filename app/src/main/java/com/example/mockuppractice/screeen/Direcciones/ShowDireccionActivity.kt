package com.example.mockuppractice.screeen.Direcciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mockuppractice.R
import com.example.mockuppractice.screeen.Direcciones.RecyclerDirecciones.DireccionAdapter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class ShowDireccionActivity : AppCompatActivity() {

    private val gson = Gson()

    private lateinit var direcciones: MutableList<formDireccion>
    private lateinit var adapter: DireccionAdapter
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_show_direccion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        showDataDirecciones()
    }

    private fun initComponents() {
        btnVolver = findViewById(R.id.btnVolver)
        btnVolver.setOnClickListener {
            //regresa a la actividad anteriror.
            finish()
        }
    }

    //Mostramos los datos en un RV de manera vertical
    private fun showDataDirecciones() {
        val recyclerView = findViewById<RecyclerView>(R.id.rvDirecciones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadDirecciones()

        adapter = DireccionAdapter(
            this,
            direcciones,
            onDeleteClicked = { position -> deleteDireccion(position) },

            )
        recyclerView.adapter = adapter
    }


    //Obtenemos las direcciones
    private fun loadDirecciones() {
        val sharedPreferences = getSharedPreferences("direccionesUsers", MODE_PRIVATE)
        val json = sharedPreferences.getString("Direcciones", "[]")
        val type = object : TypeToken<List<formDireccion>>() {}.type
        direcciones = gson.fromJson<MutableList<formDireccion>>(json, type).toMutableList()
    }


    //Para eliminar las direcciones
    private fun deleteDireccion(position: Int) {
        // Se elimina el item de la lista
        direcciones.removeAt(position)
        saveDirecciones()
        //Notifica al RV
        adapter.notifyItemRemoved(position)
        Toast.makeText(this, "Direccion Eliminada Correctamente", Toast.LENGTH_SHORT).show()
        finish()

    }

    //Guarda el estado en la que se encuentra la activity
    private fun saveDirecciones() {
        val sharedPreferences = getSharedPreferences("direccionesUsers", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val json = gson.toJson(direcciones)
        editor.putString("Direcciones", json)
        editor.apply()
    }


}