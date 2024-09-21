package com.example.mockuppractice.screeen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.R

class ShopPaymentActivity : CategoriasActivity() {

    private lateinit var btnNextDeta: ImageButton
    private lateinit var btnBfrtDeta: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shop_payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBfrtDeta = findViewById(R.id.btnLstPageDetails)
        btnNextDeta = findViewById(R.id.btnNxtPageDetails)
        changePageDetails()
        NavigationBottomNav(R.id.shopping)
    }

    private fun changePageDetails (){

        btnBfrtDeta.setOnClickListener{
            val intentbfrDetail = Intent(this, DetailsActivity::class.java)
            startActivity(intentbfrDetail)
            //finish()
        }

        btnNextDeta.setOnClickListener{
            val intentNxtDetail = Intent(this, DetailsActivity::class.java)
            startActivity(intentNxtDetail)
            //finish()
        }
    }
}