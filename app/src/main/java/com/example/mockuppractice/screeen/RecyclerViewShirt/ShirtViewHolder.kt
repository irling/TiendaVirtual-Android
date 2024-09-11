package com.example.mockuppractice.screeen.RecyclerViewShirt

import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mockuppractice.R

class ShirtViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val ibShirt = view.findViewById<ImageButton>(R.id.ibShirt)

    fun render (shirtModel: Shirt){
        Glide.with(ibShirt.context).load(shirtModel.photo).into(ibShirt)
    }

}