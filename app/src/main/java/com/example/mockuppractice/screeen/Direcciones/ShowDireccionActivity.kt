package com.example.mockuppractice.screeen.Direcciones

import android.content.Intent
import android.os.Bundle
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
        val recyclerView = findViewById<RecyclerView>(R.id.rvDirecciones)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        loadDirecciones()

        adapter = DireccionAdapter(
            this,
            direcciones,
            onEditClicked = { position -> editDireccion(position) },
            onDeleteClicked = { position -> deleteDireccion(position) }

        )
        recyclerView.adapter = adapter
    }


    private fun loadDirecciones() {
        val sharedPreferences = getSharedPreferences("direccionesUsers", MODE_PRIVATE)
        val json = sharedPreferences.getString("Direcciones", "[]")

        val type = object : TypeToken<List<formDireccion>>() {}.type
        direcciones = gson.fromJson<MutableList<formDireccion>>(json, type).toMutableList()
    }


    private fun deleteDireccion(position: Int) {
        // Se elimina el item de la lista
        direcciones.removeAt(position)

        saveDirecciones()

        //Notifica al RV
        adapter.notifyItemRemoved(position)
        Toast.makeText(this, "Direccion Eliminada Correctamente", Toast.LENGTH_SHORT).show()

    }

    private fun saveDirecciones() {
        val sharedPreferences = getSharedPreferences("direccionesUsers", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val json = gson.toJson(direcciones)
        editor.putString("Direcciones", json)
        editor.apply()
    }


    private fun editDireccion(position: Int) {
        direcciones.removeAt(position)

        //guarda las direccciones
        saveDirecciones()

        adapter.notifyItemRemoved(position)
    }

//    override fun onResume() {
//        super.onResume()
//        loadDirecciones()
//        adapter.notifyDataSetChanged()
//    }

}