package com.lukman.bwamov.wallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lukman.bwamov.R
import com.lukman.bwamov.home.HomeActivity
import com.lukman.bwamov.home.tiket.TiketActivity
import kotlinx.android.synthetic.main.activity_my_wallet_success.*

class MyWalletSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_wallet_success)
        btn_wallet.setOnClickListener {
            startActivity(Intent(this, TiketActivity::class.java))
        }
        btn_home.setOnClickListener {
            finishAffinity()

            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}