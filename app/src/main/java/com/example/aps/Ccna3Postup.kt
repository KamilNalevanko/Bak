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
import kotlinx.android.synthetic.main.content_ccna3_postup.*

class Ccna3Postup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ccna3_postup)
        setSupportActionBar(findViewById(R.id.toolbar))
        val actionbar = supportActionBar
        actionbar!!.title = "Postup v Ccna3"
        actionbar.setDisplayHomeAsUpEnabled(true)


        moduly1_2.setOnClickListener {
            moduly1_2.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly1_2.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly3_5.setOnClickListener {
            moduly3_5.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly3_5.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }

        moduly6_8.setOnClickListener {
            moduly6_8.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly6_8.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly9_12.setOnClickListener {
            moduly9_12.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly9_12.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly13_14.setOnClickListener {
            moduly13_14.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly13_14.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        if (Profil.Ccna3.modul1_2 > 51 ){
            val modul12 = findViewById<View>(R.id.modul12) as TextView
            modul12.text = "Úšpešnosť testu: " + Profil.Ccna3.modul1_2 + "%"
            modul12.setTextColor(Color.parseColor("#FFFFFF"))
            moduly1_2.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna3.modul1_2 in 1..51){
            val modul12 = findViewById<View>(R.id.modul12) as TextView
            modul12.text = "Úšpešnosť testu: " + Profil.Ccna3.modul1_2 + "%"
            modul12.setTextColor(Color.parseColor("#FFFFFF"))
            moduly1_2.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if (Profil.Ccna3.modul3_5 > 51){
            val modul35 = findViewById<View>(R.id.modul35) as TextView
            modul35.text = "Úšpešnosť testu: " + Profil.Ccna3.modul3_5 + "%"
            modul35.setTextColor(Color.parseColor("#FFFFFF"))
            moduly3_5.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna3.modul3_5 in 1..51){
            val modul35 = findViewById<View>(R.id.modul35) as TextView
            modul35.text = "Úšpešnosť testu: " + Profil.Ccna3.modul3_5 + "%"
            modul35.setTextColor(Color.parseColor("#FFFFFF"))
            moduly3_5.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorWrongAnswer),
                PorterDuff.Mode.MULTIPLY
            )}

        if ( Profil.Ccna3.modul6_8 > 51){
            val modul68 = findViewById<View>(R.id.modul68) as TextView
            modul68.text = "Úšpešnosť testu: " + Profil.Ccna3.modul6_8 + "%"
            modul68.setTextColor(Color.parseColor("#FFFFFF"))
            moduly6_8.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna3.modul6_8 in 1..51){
            val modul68 = findViewById<View>(R.id.modul68) as TextView
            modul68.text = "Úšpešnosť testu: " + Profil.Ccna3.modul6_8 + "%"
            modul68.setTextColor(Color.parseColor("#FFFFFF"))
            moduly6_8.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if (Profil.Ccna3.modul9_12 > 51){
            val modul912 = findViewById<View>(R.id.modul912) as TextView
            modul912.text = "Úšpešnosť testu: " + Profil.Ccna3.modul9_12 + "%"
            modul912.setTextColor(Color.parseColor("#FFFFFF"))
            moduly9_12.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna3.modul9_12 in 1..51){
            val modul912 = findViewById<View>(R.id.modul912) as TextView
            modul912.text = "Úšpešnosť testu: " + Profil.Ccna3.modul9_12 + "%"
            modul912.setTextColor(Color.parseColor("#FFFFFF"))
            moduly9_12.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if ( Profil.Ccna3.modul13_14 > 51){
            val modul1314 = findViewById<View>(R.id.modul1314) as TextView
            modul1314.text = "Úšpešnosť testu: " + Profil.Ccna3.modul13_14 + "%"
            modul1314.setTextColor(Color.parseColor("#FFFFFF"))
            moduly13_14.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna3.modul13_14 in 1..51){
            val modul1314 = findViewById<View>(R.id.modul1314) as TextView
            modul1314.text = "Úšpešnosť testu: " + Profil.Ccna3.modul13_14 + "%"
            modul1314.setTextColor(Color.parseColor("#FFFFFF"))
            moduly13_14.background.setColorFilter(
                ContextCompat.getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}