package com.example.aps

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_reset_password.*

class ResetPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)


        StatusBarUtil.setTransparent(this)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        }


        imageView5.animate().apply {
            duration=2000
            alpha(1f)
        }.start()


        btn_sumbit.setOnClickListener {
            val email: String = reset.text.toString().trim{it<=' '}
            if(email.isEmpty()){
                Toast.makeText(
                    this@ResetPasswordActivity,
                    "Prosím zadajte email.",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{task ->
                        if(task.isSuccessful){
                        Toast.makeText(
                            this@ResetPasswordActivity,
                            "Email na reset hesla bol úspešne zaslaný !",
                            Toast.LENGTH_LONG
                        ).show()
                        finish()
                    }else{
                            Toast.makeText(
                                this@ResetPasswordActivity,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()

                        }
                    }
            }
                btn_sumbit.animate().apply {
                duration = 150
                translationY(-20f)
            }.withEndAction {
                    btn_sumbit.animate().apply {
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