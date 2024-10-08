package com.example.mockuppractice.screeen.Direcciones.RecyclerDirecciones

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mockuppractice.R
import com.example.mockuppractice.screeen.Direcciones.formDireccion

//ADAPATE DEL RECYCLER VIEW
class DireccionAdapter(
    private val context: Context,
    private val direcciones: MutableList<formDireccion>,
    private val onDeleteClicked: (Int) -> Unit
) : RecyclerView.Adapter<DireccionAdapter.DireccionViewHolder>() {


    //VIEWHOLDER DEL RECYCLER VIEW
    class DireccionViewHolder(View: View) : RecyclerView.ViewHolder(View){
        //llamamos los datos del XML
        val tvDireccion: TextView = itemView.findViewById(R.id.tvDireccion)
        val tvNumeroCasa: TextView = itemView.findViewById(R.id.tvNumeroCasa)
        val tvTipoDomi: TextView = itemView.findViewById(R.id.tvTipoDomi)
        val tvReferencia: TextView = itemView.findViewById(R.id.tvReferencia)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DireccionViewHolder {
        //Mostramos la data del Layaout
        val view = LayoutInflater.from(context).inflate(R.layout.item_show_direccion, parent, false)
        return DireccionViewHolder(view)
    }

    //Se mostrara la data obtenida en el RV
    override fun onBindViewHolder(holder: DireccionViewHolder, position: Int) {
        val direccion = direcciones[position]

        holder.tvDireccion.text = "Dirección: ${direccion.direccion}"
        holder.tvNumeroCasa.text = "Número: ${direccion.numeroDire}"
        holder.tvTipoDomi.text = "Tipo Domicilio: ${direccion.tipoDomi}"
        holder.tvReferencia.text = "Referencia: ${direccion.referencia}"


        // Botón de Eliminar
        holder.btnDelete.setOnClickListener {
            onDeleteClicked(position)
        }

    }

    override fun getItemCount(): Int = direcciones.size


}