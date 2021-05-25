package com.example.aps

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.alpha
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.aps.Login.prihlaseny.logged
import com.example.aps.TestyTemy3.cisloJson3.number
import com.example.aps.ui.profil.UserFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jaeger.library.StatusBarUtil
import com.toxicbakery.bcrypt.Bcrypt
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_reset_password.*


class Login : AppCompatActivity() {
    internal lateinit var login: Button

    object prihlaseny {
        var number: Int = 0
        var logged: Boolean=false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        StatusBarUtil.setTransparent(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
          //  window.statusBarColor = Color.WHITE
        }

        tv_register.setOnClickListener{
            startActivity(Intent(this@Login,Register::class.java))
            overridePendingTransition(R.anim.to_right,R.anim.slide_out_left)
            finish()
        }
        passwordreset.setOnClickListener{
            startActivity(Intent(this@Login,ResetPasswordActivity::class.java))
            overridePendingTransition(R.anim.to_right,R.anim.slide_out_left)
            finish()
        }

        imageView7.animate().apply {
            duration=2000
            alpha(1f)
        }.start()


        btn_login.setOnClickListener{


            progressBar2.visibility=View.VISIBLE
            when{

                TextUtils.isEmpty(et_login_email.text.toString().trim{ it<=' '}) ->{
                    Toast.makeText(
                        this@Login,
                        "Prosím zadajte email.",
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar2.visibility=View.GONE
                }
                TextUtils.isEmpty(et_login_password.text.toString().trim{ it<=' '}) ->{
                    Toast.makeText(
                        this@Login,
                        "Prosím zadajte heslo.",
                        Toast.LENGTH_SHORT
                    ).show()
                    progressBar2.visibility=View.GONE
                }
                else -> {

                    val email: String = et_login_email.text.toString().trim{it<=' '}
                    var password: String = et_login_password.text.toString().trim{it<=' '}


                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener{ task->

                                if(task.isSuccessful){

                                    val sp = getSharedPreferences("Login", Context.MODE_PRIVATE)
                                    val Ed = sp.edit()

                                    Ed.putInt("prihlaseny", 1)
                                    Ed.putString("Email", email)
                                    Ed.apply()

                                    val user = FirebaseAuth.getInstance().currentUser
                                    val firebaseUser: FirebaseUser =task.result!!.user!!

                                    if(user.isEmailVerified){
                                        val hash = Bcrypt.hash(password, 12)
                                        if (Bcrypt.verify(password, hash)) {
                                            Log.d("správne heslo" , "správne heslo")
                                        }
                                    Toast.makeText(
                                        this@Login,
                                        "Úspešne prihlásený.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                        logged=true
                                        var id=FirebaseAuth.getInstance().currentUser!!.uid  // dostatie user idčka
                                        Ed.putString("user_id", id)
                                        Ed.putBoolean("Verified", true)
                                        Ed.apply()
                                     val intent= Intent(this@Login,Profil::class.java).apply{}
                                     intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                     startActivity(intent) //
                                     finish()

                                } else {
                                        progressBar2.visibility=View.GONE
                                        Toast.makeText(
                                            this@Login,
                                            "Pre prihlásenie je potrebné potvrdiť overovací link, zaslaný na emailovú adresu.",
                                            Toast.LENGTH_LONG

                                        ).show()

                                    } } else {
                                    progressBar2.visibility=View.GONE
                                    Toast.makeText(
                                        this@Login,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }
                }
            }

            btn_login.animate().apply {
                duration = 150
                translationY(-20f)
            }.withEndAction {
                btn_login.animate().apply {
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