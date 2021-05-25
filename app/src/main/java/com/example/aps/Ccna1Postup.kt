package com.example.aps

import android.content.res.ColorStateList
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Color.RED
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import kotlinx.android.synthetic.main.content_ccna1_postup.*
import kotlinx.android.synthetic.main.nav_header_main.*

class Ccna1Postup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ccna1_postup)
        setSupportActionBar(findViewById(R.id.toolbar))
        val actionbar = supportActionBar
        actionbar!!.title = "Postup v Ccna1"
        actionbar.setDisplayHomeAsUpEnabled(true)


        moduly1_3.setOnClickListener {
            moduly1_3.animate().apply {
                 duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly1_3.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly4_7.setOnClickListener {
            moduly4_7.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly4_7.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }

        moduly8_10.setOnClickListener {
            moduly8_10.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly8_10.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly11_13.setOnClickListener {
            moduly11_13.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly11_13.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly14_15.setOnClickListener {
            moduly14_15.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly14_15.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }
        moduly16_17.setOnClickListener {
            moduly16_17.animate().apply {
                duration = 150
                scaleY(1.1f)
                scaleX(1.1f)
            }.withEndAction {
                moduly16_17.animate().apply {
                    duration = 150
                    scaleX(1f)
                    scaleY(1f)
                }
            }.start()
        }



        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK

        if (Profil.Ccna1.modul1_3 > 51 ){
            val modul13 = findViewById<View>(R.id.modul13) as TextView
            modul13.text = "Úšpešnosť testu: " + Profil.Ccna1.modul1_3 + "%"
            modul13.setTextColor(Color.parseColor("#FFFFFF"))
            moduly1_3.background.setColorFilter(
                getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna1.modul1_3 in 1..51){
             val modul13 = findViewById<View>(R.id.modul13) as TextView
             modul13.text = "Úšpešnosť testu: " + Profil.Ccna1.modul1_3 + "%"
             modul13.setTextColor(Color.parseColor("#FFFFFF"))
            moduly1_3.background.setColorFilter(
                getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )

        }

        if (Profil.Ccna1.modul4_7 > 51){
            val modul47 = findViewById<View>(R.id.modul47) as TextView
            modul47.text = "Úšpešnosť testu: " + Profil.Ccna1.modul4_7 + "%"
            modul47.setTextColor(Color.parseColor("#FFFFFF"))
            moduly4_7.background.setColorFilter(
                getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna1.modul4_7 in 1..51){
            val modul47 = findViewById<View>(R.id.modul47) as TextView
            modul47.text = "Úšpešnosť testu: " + Profil.Ccna1.modul4_7 + "%"
            modul47.setTextColor(Color.parseColor("#FFFFFF"))
            moduly4_7.background.setColorFilter(
                getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if ( Profil.Ccna1.modul8_10 > 51){
            val modul810 = findViewById<View>(R.id.modul810) as TextView
            modul810.text = "Úšpešnosť testu: " + Profil.Ccna1.modul8_10 + "%"
            modul810.setTextColor(Color.parseColor("#FFFFFF"))
            when (currentNightMode) {
                Configuration.UI_MODE_NIGHT_NO -> {} // Night mode is not active, we're using the light theme
                Configuration.UI_MODE_NIGHT_YES -> {} // Night mode is active, we're using dark theme
            }
            moduly8_10.background.setColorFilter(
                getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna1.modul8_10 in 1..51){
            val modul810 = findViewById<View>(R.id.modul810) as TextView
            modul810.text = "Úšpešnosť testu: " + Profil.Ccna1.modul8_10 + "%"
            modul810.setTextColor(Color.parseColor("#FFFFFF"))

            moduly8_10.background.setColorFilter(
                getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )
        }

        if (Profil.Ccna1.modul11_13 > 51){
            val modul1113 = findViewById<View>(R.id.modul1113) as TextView
            modul1113.text = "Úšpešnosť testu: " + Profil.Ccna1.modul11_13 + "%"
            modul1113.setTextColor(Color.parseColor("#FFFFFF"))
            moduly11_13.background.setColorFilter(
                getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna1.modul11_13 in 1..51){
            val modul1113 = findViewById<View>(R.id.modul1113) as TextView
            modul1113.text = "Úšpešnosť testu: " + Profil.Ccna1.modul11_13 + "%"
            modul1113.setTextColor(Color.parseColor("#FFFFFF"))
            moduly11_13.background.setColorFilter(
                getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if ( Profil.Ccna1.modul14_15 > 51){
            val modul1415 = findViewById<View>(R.id.modul1415) as TextView
            modul1415.text = "Úšpešnosť testu: " + Profil.Ccna1.modul14_15 + "%"
            modul1415.setTextColor(Color.parseColor("#FFFFFF"))
            moduly14_15.background.setColorFilter(
                getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna1.modul14_15 in 1..51){
            val modul1415 = findViewById<View>(R.id.modul1415) as TextView
            modul1415.text = "Úšpešnosť testu: " + Profil.Ccna1.modul14_15 + "%"
            modul1415.setTextColor(Color.parseColor("#FFFFFF"))
            moduly14_15.background.setColorFilter(
                getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}

        if (Profil.Ccna1.modul16_17 > 51){
            val modul1617 = findViewById<View>(R.id.modul1617) as TextView
            modul1617.text = "Úšpešnosť testu: " + Profil.Ccna1.modul16_17 + "%"
            modul1617.setTextColor(Color.parseColor("#FFFFFF"))
            moduly16_17.background.setColorFilter(
                getColor(this, R.color.colorCorrectAnswer),
                PorterDuff.Mode.MULTIPLY
            )
        }else if(Profil.Ccna1.modul16_17 in 1..51){
            val modul1617 = findViewById<View>(R.id.modul1617) as TextView
            modul1617.text = "Úšpešnosť testu: " + Profil.Ccna1.modul16_17 + "%"
            modul1617.setTextColor(Color.parseColor("#FFFFFF"))
            moduly16_17.background.setColorFilter(
                getColor(this, R.color.red),
                PorterDuff.Mode.MULTIPLY
            )}


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}