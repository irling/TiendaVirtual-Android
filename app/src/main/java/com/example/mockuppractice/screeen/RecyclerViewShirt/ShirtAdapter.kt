package com.example.mockuppractice.screeen.RecyclerViewShirt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mockuppractice.R

class ShirtAdapter (private val shirtList: List<Shirt>):RecyclerView.Adapter<ShirtViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShirtViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShirtViewHolder(layoutInflater.inflate(R.layout.item_shirt, parent, false))
    }

    override fun onBindViewHolder(holder: ShirtViewHolder, position: Int) {
        val item = shirtList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = shirtList.size

}