package com.example.mockuppractice.screeen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mockuppractice.R
import com.example.mockuppractice.databinding.ActivityShirtBinding
import com.example.mockuppractice.screeen.RecyclerViewShirt.ShirtAdapter
import com.example.mockuppractice.screeen.RecyclerViewShirt.ShirtProvider

class ShirtActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShirtBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityShirtBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        renderShirt()
    }

    private fun renderShirt() {
        binding.rvShirt.layoutManager = LinearLayoutManager(this)
        binding.rvShirt.adapter = ShirtAdapter(ShirtProvider.ShirtListFirst)
    }
}