package com.example.mockuppractice.screeen.RecyclerViewBags

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mockuppractice.R

class BagsAdapter(private val bagList: List<Bags>) : RecyclerView.Adapter<BagsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BagsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return BagsViewHolder(layoutInflater.inflate(R.layout.item_bags, parent, false))
    }

    override fun onBindViewHolder(holder: BagsViewHolder, position: Int) {
        val item = bagList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = bagList.size

}