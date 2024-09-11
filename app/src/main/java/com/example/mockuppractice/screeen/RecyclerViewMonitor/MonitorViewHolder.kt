package com.example.mockuppractice.screeen.RecyclerViewMonitor

import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mockuppractice.R

class MonitorViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val ibMonitor = view.findViewById<ImageButton>(R.id.ibMonitor)

    fun render (monitorModel: Monitor){
        Glide.with(ibMonitor.context).load(monitorModel.photo).into(ibMonitor)
    }

}