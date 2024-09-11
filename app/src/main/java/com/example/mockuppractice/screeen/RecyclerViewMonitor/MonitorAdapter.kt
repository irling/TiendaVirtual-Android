package com.example.mockuppractice.screeen.RecyclerViewMonitor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mockuppractice.R

class MonitorAdapter (private val monitorList: List<Monitor> ): RecyclerView.Adapter<MonitorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonitorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MonitorViewHolder(layoutInflater.inflate(R.layout.item_monitor, parent, false))
    }

    override fun onBindViewHolder(holder: MonitorViewHolder, position: Int) {
        val item = monitorList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = monitorList.size
}