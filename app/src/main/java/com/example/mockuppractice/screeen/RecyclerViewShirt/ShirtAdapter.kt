package com.example.mockuppractice.screeen.RecyclerViewShirt

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mockuppractice.R
import com.example.mockuppractice.screeen.CategoriasActivity
import com.example.mockuppractice.screeen.RecyclerViewShirt.PagesShirt.Shirt01

class ShirtAdapter(private val shirtList: List<Shirt>) : RecyclerView.Adapter<ShirtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShirtViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShirtViewHolder(layoutInflater.inflate(R.layout.item_shirt, parent, false))
    }

    override fun onBindViewHolder(holder: ShirtViewHolder, position: Int) {
        val item = shirtList[position]
        holder.render(item)

        //ingresa a la actividad asignada en el dataClass : Shirt
        holder.ibShirt.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, item.targetActivity)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = shirtList.size

}