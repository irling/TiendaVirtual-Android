package com.example.mockuppractice.screeen.RecyclerViewBags

import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mockuppractice.R

class BagsViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val ibBags = view.findViewById<ImageButton>(R.id.ibBags)

    fun render (bagModel: Bags){
        Glide.with(ibBags.context).load(bagModel.photo).into(ibBags)

    }

}