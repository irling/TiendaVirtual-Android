package com.example.mockuppractice.screeen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mockuppractice.R
import com.example.mockuppractice.databinding.ActivityBagsBinding
import com.example.mockuppractice.screeen.RecyclerViewBags.BagsAdapter
import com.example.mockuppractice.screeen.RecyclerViewBags.BagsProvider

class BagsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBagsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBagsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        renderBags()
    }

    private fun renderBags (){
        binding.rvBags.layoutManager = LinearLayoutManager(this)
        binding.rvBags.adapter = BagsAdapter(BagsProvider.BagsListFirst)
    }

}