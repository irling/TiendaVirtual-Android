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

class CategoriasActivity : AppCompatActivity() {

    private lateinit var btnShirt: ImageButton
    private lateinit var btnMonitor: ImageButton
    private lateinit var btnShopPayment: ImageButton
    private lateinit var btnBag: ImageButton
    private lateinit var btnShop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_categorias)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBag = findViewById(R.id.imgBtnBag)
        btnMonitor = findViewById(R.id.imgBtnMonitor)
        btnShopPayment = findViewById(R.id.imgBtnShop)
        btnShirt = findViewById(R.id.imgBtnShirt)
        btnShop = findViewById(R.id.btnGoShop)

        changeScreen()

    }

    private fun changeScreen() {
        btnMonitor.setOnClickListener {
            val intentSCMonitor = Intent(this, MonitorActivity::class.java)
            startActivity(intentSCMonitor)
        }
        btnBag.setOnClickListener {
            val intentSCBag = Intent(this, BagsActivity::class.java)
            startActivity(intentSCBag)
        }

        btnShopPayment.setOnClickListener {
            val intentSCShopPay = Intent(this, ShopPaymentActivity::class.java)
            startActivity(intentSCShopPay)
        }

        btnShirt.setOnClickListener {
            val intentSCShirt = Intent(this, ShirtActivity::class.java)
            startActivity(intentSCShirt)
        }

        btnShop.setOnClickListener{
            val intentShop = Intent(this, ShopPaymentActivity::class.java)
            startActivity(intentShop)
        }

    }

}