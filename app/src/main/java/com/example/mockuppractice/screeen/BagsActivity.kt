package com.example.mockuppractice.screeen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
    private lateinit var btngoShop: Button


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
        btngoShop = findViewById(R.id.btnGoShop)
        screenShop()
    }

    private fun renderBags (){
        binding.rvBags.layoutManager = LinearLayoutManager(this)
        binding.rvBags.adapter = BagsAdapter(BagsProvider.BagsListFirst)
    }

    private fun screenShop (){
        btngoShop.setOnClickListener{
            val intentShop = Intent(this, ShopPaymentActivity::class.java)
            startActivity(intentShop)
        }
    }

}