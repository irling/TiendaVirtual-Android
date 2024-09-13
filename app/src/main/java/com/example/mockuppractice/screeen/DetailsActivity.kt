package com.example.mockuppractice.screeen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.R

class DetailsActivity : AppCompatActivity() {

    private lateinit var btnNextShop: ImageButton
    private lateinit var btnBfrtShop: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBfrtShop = findViewById(R.id.btnLstPageShop)
        btnNextShop = findViewById(R.id.btnNxtPageShop)
        changePageDetails()
    }

    private fun changePageDetails (){

        btnBfrtShop.setOnClickListener{
            val intentbfrDetail = Intent(this, ShopPaymentActivity::class.java)
            startActivity(intentbfrDetail)
            finish()
        }

        btnNextShop.setOnClickListener{
            val intentNxtDetail = Intent(this, ShopPaymentActivity::class.java)
            startActivity(intentNxtDetail)
            finish()
        }
    }
}