package com.lukman.bwamov.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lukman.bwamov.R
import com.lukman.bwamov.home.HomeActivity
import com.lukman.bwamov.home.tiket.TiketActivity
import kotlinx.android.synthetic.main.activity_checkout_success.*

class CheckoutSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_success)
        btn_tiket.setOnClickListener {
            var intent = Intent(this, TiketActivity::class.java)
            startActivity(intent)
        }
        btn_home.setOnClickListener {
            finishAffinity()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}