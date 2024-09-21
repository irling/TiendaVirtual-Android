package com.example.mockuppractice.screeen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mockuppractice.SettingsActivity
import com.example.mockuppractice.R
import com.example.mockuppractice.screeen.Direcciones.DireccionActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

open class CategoriasActivity : AppCompatActivity() {

    private lateinit var btnShirt: ImageButton
    private lateinit var btnMonitor: ImageButton
    private lateinit var btnShopPayment: ImageButton
    private lateinit var btnBag: ImageButton

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


        changeScreen()
        NavigationBottomNav(R.id.home)

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

    }

    //NAVEGACION CON NAVIGATION VIEW
    open fun NavigationBottomNav(selectedItemId: Int) {
        val bottonNav =  findViewById<BottomNavigationView>(R.id.BottomNavigation)

        //PARA QUE SE SELECCIONE DEPENDIENDO LA ACTIVIDAD QUE SE ENCUENTRE
        bottonNav.selectedItemId = selectedItemId

        bottonNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    val intentHomeCat = Intent(this, CategoriasActivity::class.java)
                    intentHomeCat.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    startActivity(intentHomeCat)
                    finish()
                    true
                }

                R.id.shopping -> {
                    val intentShop = Intent(this, ShopPaymentActivity::class.java)
                    intentShop.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    startActivity(intentShop)
                    finish()
                    true
                }

                R.id.setting -> {
                    val intentSetting = Intent(this, SettingsActivity::class.java)
                    intentSetting.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    startActivity(intentSetting)
                    finish()
                    true
                }

                R.id.address ->{
                    val intentAddress = Intent(this, DireccionActivity::class.java)
                    intentAddress.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    startActivity(intentAddress)
                    finish()
                    true
                }

                else -> false
            }
        }
    }

}