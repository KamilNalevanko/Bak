package com.example.aps

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.aps.Login.prihlaseny.logged
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.jaeger.library.StatusBarUtil
import com.toxicbakery.bcrypt.Bcrypt
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_reset_password.*


class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            // firebase databaza

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Uzivatel")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // lokalne ulozisko údajov
        val sp = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val Ed = sp.edit()

        imageView6.animate().apply {
            duration=2000
            alpha(1f)
        }.start()


        StatusBarUtil.setTransparent(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            //  window.statusBarColor = Color.WHITE
        }

        logged=false
        tv_login.setOnClickListener{
            startActivity(Intent(this@Register,Login::class.java))
            overridePendingTransition(R.anim.to_left,R.anim.slide_out_right)
            finish()
        }


        btn_register.setOnClickListener{
            when{
                TextUtils.isEmpty(et_register_email.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@Register,
                        "Prosím zadajte email.",
                         Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(et_register_password.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@Register,
                        "Prosím zadajte heslo.",
                         Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(et_register_password2.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@Register,
                        "Overte zadané heslo.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(et_register_name.text.toString().trim{ it <= ' ' }) -> {
                    Toast.makeText(
                        this@Register,
                        "Prosím zadajte meno.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {

                    val email: String = et_register_email.text.toString().trim { it <= ' ' }
                    var password: String = et_register_password.text.toString().trim { it <= ' ' }
                    val name: String = et_register_name.text.toString().trim { it <= ' ' }
                    var password1: String = et_register_password2.text.toString().trim { it <= ' ' }

                    if (password.equals(password1)) {

                            FirebaseAuth.getInstance()
                                .createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(
                                    OnCompleteListener<AuthResult> { task ->

                                        if (task.isSuccessful) {

                                            val user = FirebaseAuth.getInstance().currentUser
                                            val firebaseUser: FirebaseUser = task.result!!.user!!
                                            val userid =
                                                FirebaseAuth.getInstance().currentUser!!.uid
                                            if (userid != null) {
                                                Profil.profil.Id = userid
                                            }

                                            // Ed.putString("Name", name)
                                            Ed.putString("Email", email)
                                            Ed.putInt("prihlaseny", 1)
                                            Ed.putBoolean("Verified", false)
                                            Ed.apply()

                                            // vytvorenie uloziska pre moduly
                                            var Ccna1 = Ccna1(0, 0, 0, 0, 0, 0)
                                            var Ccna2 = Ccna2(0, 0, 0, 0, 0)
                                            var Ccna3 = Ccna3(0, 0, 0, 0, 0)

                                            var model = UserInfo(name, email)

                                            myRef.child(userid).setValue(model)
                                            // skuska ako vytvorit child v childe
                                            myRef.child(userid).child("Ccna1").setValue(Ccna1)
                                            myRef.child(userid).child("Ccna2").setValue(Ccna2)
                                            myRef.child(userid).child("Ccna3").setValue(Ccna3)

                                            user.sendEmailVerification()
                                            Toast.makeText(
                                                this@Register,
                                                "Registrácia prebehla úspešne. Skontrolujte si email pre potvrdenie registrácie.",
                                                Toast.LENGTH_LONG
                                            ).show()

                                            val intent = Intent(this@Register, Login::class.java)
                                            intent.flags =
                                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                            startActivity(intent)
                                            finish()

                                        } else {

                                            Toast.makeText(
                                                this@Register,
                                                task.exception!!.message.toString(),
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    })
                    } else{
                        Toast.makeText(
                            this@Register,
                            "Zadané heslá sa nezhodujú.",
                            Toast.LENGTH_LONG
                        ).show()// ci sa rovna hesl oa kontrolne
                    }
                }

            }
           btn_register.animate().apply {
                duration = 150
                translationY(-20f)
            }.withEndAction {
                btn_register.animate().apply {
                    duration = 150
                    translationY(20f)
                }
            }.start()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.to_left,R.anim.slide_out_right)
    }
}