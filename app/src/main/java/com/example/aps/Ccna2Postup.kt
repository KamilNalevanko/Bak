package com.example.aps

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.content_ccna1_postup.*
import kotlinx.android.synthetic.main.content_ccna2_postup.*
import kotlinx.android.synthetic.main.content_ccna3_postup.*

class Ccna2Postup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ccna2_postup)
        setSupportActionBar(findViewById(R.id.toolbar))
        val actionbar = supportActionBar
        actionbar!!.title = "Postup v Ccna2"
        actionbar.setDisplayHomeAsUpEnabled(true)

        moduly1_4.setOnClickListener {
            moduly1_4.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly1_4.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly5_6.setOnClickListener {
            moduly5_6.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly5_6.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }

        moduly7_9.setOnClickListener {
            moduly7_9.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly7_9.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly10_13.setOnClickListener {
            moduly10_13.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly10_13.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly14_16.setOnClickListener {
            moduly14_16.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly14_16.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }

        if (Profil.Ccna2.modul1_4 > 51 ){
            val modul14 = findViewById<View>(R.id.modul14) as TextView
            modul14.text = "Úšpešnosť testu: " + Profil.Ccna2.modul1_4 + "%"
            modul14.setTextColor(Color.parseColor("#FFFFFF"))
            moduly1_4.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna2.modul1_4 in 1..51){
            val modul14 = findViewById<View>(R.id.modul14) as TextView
            modul14.text = "Úšpešnosť testu: " + Profil.Ccna2.modul1_4 + "%"
            modul14.setTextColor(Color.parseColor("#FFFFFF"))
            moduly1_4.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if (Profil.Ccna2.modul5_6> 51){
            val modul56 = findViewById<View>(R.id.modul56) as TextView
            modul56.text = "Úšpešnosť testu: " + Profil.Ccna2.modul5_6 + "%"
            modul56.setTextColor(Color.parseColor("#FFFFFF"))
            moduly5_6.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna2.modul5_6 in 1..51){
            val modul56 = findViewById<View>(R.id.modul56) as TextView
            modul56.text = "Úšpešnosť testu: " + Profil.Ccna2.modul5_6 + "%"
            modul56.setTextColor(Color.parseColor("#FFFFFF"))
            moduly5_6.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if ( Profil.Ccna2.modul7_9 > 51){
            val modul79 = findViewById<View>(R.id.modul79) as TextView
            modul79.text = "Úšpešnosť testu: " + Profil.Ccna2.modul7_9 + "%"
            modul79.setTextColor(Color.parseColor("#FFFFFF"))
            moduly7_9.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna2.modul7_9 in 1..51){
            modul79.setTextColor(Color.parseColor("#FFFFFF"))
            val modul79 = findViewById<View>(R.id.modul79) as TextView
            modul79.text = "Úšpešnosť testu: " + Profil.Ccna2.modul7_9 + "%"
            moduly7_9.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if (Profil.Ccna2.modul10_13 > 51){
            val modul1013 = findViewById<View>(R.id.modul1013) as TextView
            modul1013.text = "Úšpešnosť testu: " + Profil.Ccna2.modul10_13 + "%"
            modul1013.setTextColor(Color.parseColor("#FFFFFF"))
            moduly10_13.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna2.modul10_13 in 1..51){
            val modul1013 = findViewById<View>(R.id.modul1013) as TextView
            modul1013.setTextColor(Color.parseColor("#FFFFFF"))
            modul1013.text = "Úšpešnosť testu: " + Profil.Ccna2.modul10_13 + "%"
            moduly10_13.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if ( Profil.Ccna2.modul14_16 > 51){
            val modul1416 = findViewById<View>(R.id.modul1416) as TextView
            modul1416.text = "Úšpešnosť testu: " + Profil.Ccna2.modul14_16 + "%"
            modul1416.setTextColor(Color.parseColor("#FFFFFF"))
            moduly14_16.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna2.modul14_16 in 1..51){
            val modul1416 = findViewById<View>(R.id.modul1416) as TextView
            modul1416.text = "Úšpešnosť testu: " + Profil.Ccna2.modul14_16 + "%"
            modul1416.setTextColor(Color.parseColor("#FFFFFF"))
            moduly14_16.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}