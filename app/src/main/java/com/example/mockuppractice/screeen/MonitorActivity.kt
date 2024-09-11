package com.example.mockuppractice.screeen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mockuppractice.R
import com.example.mockuppractice.databinding.ActivityMonitorBinding
import com.example.mockuppractice.screeen.RecyclerViewMonitor.MonitorAdapter
import com.example.mockuppractice.screeen.RecyclerViewMonitor.MonitorProvider
import com.example.mockuppractice.screeen.RecyclerViewMonitor.MonitorViewHolder

class MonitorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMonitorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMonitorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        renderMonitor()
    }

    private fun renderMonitor() {
        binding.rvMonitor.layoutManager = LinearLayoutManager(this)
        binding.rvMonitor.adapter = MonitorAdapter(MonitorProvider.MonitorListFirst)
    }


}