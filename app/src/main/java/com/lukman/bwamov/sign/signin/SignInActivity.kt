package com.lukman.bwamov.sign.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.lukman.bwamov.home.HomeActivity
import com.lukman.bwamov.R
import com.lukman.bwamov.sign.signup.SignUpActivity
import com.lukman.bwamov.utils.Preferances
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity() {
    lateinit var iUsername:String
    lateinit var iPassword:String
    lateinit var mDatabase: DatabaseReference
    lateinit var preferance : Preferances
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in);
        mDatabase = FirebaseDatabase.getInstance().getReference("User")
        preferance = Preferances(this)
        preferance.setValue("onboarding", "1")
        if(preferance.getValues("status").equals("1")) {
            finishAffinity()
            var goHome = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(goHome)
        }
        btn_home.setOnClickListener {
           iUsername = et_username.text.toString()
           iPassword = et_password.text.toString()
            if(iUsername.equals("")) {
                et_username.error = "Silahkan tulis username Anda"
                et_username.requestFocus()
            } else if(iPassword.equals("")) {
                et_password.error = "Silahkan tulis password Anda"
                et_password.requestFocus()
            } else {
                pushLogin(iUsername, iPassword)
            }
        }
        btn_daftar.setOnClickListener {
            var goSigup = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(goSigup)
        }
    }

    private fun pushLogin(iUsername: String, iPassword: String) {
        mDatabase.child(iUsername).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@SignInActivity, databaseError.message, Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var user = dataSnapshot.getValue(User::class.java)
                if(user == null) {
                    Toast.makeText(this@SignInActivity, "Username / Password salah", Toast.LENGTH_LONG).show()
                } else if (user.password.equals(iPassword)) {
                    preferance.setValue("nama", user.nama.toString())
                    preferance.setValue("user", user.username.toString())
                    preferance.setValue("url", user.url.toString())
                    preferance.setValue("email", user.email.toString())
                    preferance.setValue("saldo", user.saldo.toString())
                    preferance.setValue("status", "1")
                    var intent = Intent(this@SignInActivity, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignInActivity, "Username / Password salah", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}