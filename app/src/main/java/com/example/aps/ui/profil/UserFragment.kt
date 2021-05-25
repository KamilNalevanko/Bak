package com.example.aps.ui.profil

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.aps.Login
import com.example.aps.Login.prihlaseny.logged
import com.example.aps.Profil
import com.example.aps.Profil.profil.gender
import com.example.aps.Profil.profil.name
import com.example.aps.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_user2.*
import kotlinx.android.synthetic.main.nav_header_main.*


class UserFragment : Fragment() {

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Uzivatel")


    private lateinit var profilViewModel: ProfilViewModel
    var t: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        if(logged!=false){FirebaseAuth.getInstance().signOut()}
        if (!logged) { // toto je fragment ked neni lognuty
            profilViewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)

            return inflater.inflate(R.layout.fragment_user, container, false)

        }

        profilViewModel = ViewModelProvider(this).get(ProfilViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_user2, container, false)

        val myInflatedView: View = inflater.inflate(R.layout.fragment_user2, container, false)

        val tx1 = root.findViewById(R.id.user_email) as TextView
        tx1.text = Profil.profil.Email

        val tx = root.findViewById(R.id.user_name) as TextView
        tx.text = name


 /*
        // darkmode

        // Declare the switch from the layout file
        val prepinac = root.findViewById<Switch>(R.id.switch1)

        // set the switch to listen on checked change
        prepinac.setOnCheckedChangeListener { _, isChecked ->

            // if the button is checked, i.e., towards the right or enabled
            // enable dark mode, change the text to disable dark mode
            // else keep the switch text to enable dark mode
            if (prepinac.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                prepinac.text = "Disable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                prepinac.text = "Enable dark mode"
            }
        }
*/
        // vypocet % kolko je hotovo z danych CCNA a vypisanie toho

        val simpleProgressBar =root.findViewById(R.id.progressBar1)as ProgressBar
        var progress4: Int = 0
        var progress2: Int = 0
        var progress3: Int = 0
        var result = 123F


        simpleProgressBar.max = 100

        if(Profil.Ccna1.modul1_3>51){
            progress4+= 1
        }
        if(Profil.Ccna1.modul4_7 >51){
            progress4 += 1

        }
        if(Profil.Ccna1.modul8_10>51){
            progress4 += 1

        }
        if(Profil.Ccna1.modul11_13>51){
            progress4 += 1

        }
        if(Profil.Ccna1.modul14_15>51){
            progress4 += 1

        }
        if(Profil.Ccna1.modul16_17>51){
            progress4 += 1

        }
        result = (progress4*(100.0 / 6.0)).toFloat()

        simpleProgressBar.progress = Math.round(result)

        val percenta = root.findViewById(R.id.textView16) as TextView
        percenta.text = Math.round(result).toString() + "%"

        Log.d("Hodnota progresu4 je " + result,"Vysledok")
        // vypocet % kolko je hotovo z danych CCNA a vypisanie toho

        val simpleProgressBar1 =root.findViewById(R.id.progressBar2)as ProgressBar

        simpleProgressBar1.max = 100

        if(Profil.Ccna2.modul1_4>51){
            progress2 += 1
        }
        if(Profil.Ccna2.modul5_6 >51){
            progress2 += 1
        }
        if(Profil.Ccna2.modul7_9>51){
            progress2 += 1
        }
        if(Profil.Ccna2.modul10_13>51){
            progress2 += 1
        }
        if(Profil.Ccna2.modul14_16>51){
            progress2 += 1
        }

        progress2 *= (100 / 5)

        simpleProgressBar1.progress = progress2

        val percenta1 = root.findViewById(R.id.textView17) as TextView
        percenta1.text = progress2.toString() + "%"
        Log.d("Hodnota progresu2 je " + progress2,"Vysledok")
        // vypocet % kolko je hotovo z danych CCNA a vypisanie toho
        val simpleProgressBar2 =root.findViewById(R.id.progressBar3)as ProgressBar

        simpleProgressBar2.max = 100

        if(Profil.Ccna3.modul1_2>51){
            progress3 += 1
        }
        if(Profil.Ccna3.modul3_5 >51){
            progress3 += 1
        }
        if(Profil.Ccna3.modul6_8>51){
            progress3 += 1
        }
        if(Profil.Ccna3.modul9_12>51){
            progress3 += 1
        }
        if(Profil.Ccna3.modul13_14>51){
            progress3 += 1
        }

        progress3 *= (100 / 5)

        simpleProgressBar2.progress = progress3
        val percenta2 = root.findViewById(R.id.textView18) as TextView
        percenta2.text = progress3.toString() + "%"
        return root

    }


}

