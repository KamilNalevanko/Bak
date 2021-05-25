package com.example.aps
// Import

import android.animation.ObjectAnimator
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.aps.Profil.profil.Email
import com.example.aps.Profil.profil.gender
import com.example.aps.Profil.profil.prihlaseny
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jaeger.library.StatusBarUtil



class Profil : AppCompatActivity() {
    object profil {
        var name=""
        var prihlaseny = 0
        var Email="m"
        var Id="x"
        var gender=0
    }

    object Ccna1 {
        var ccna1=0
        var modul1_3 = 0
        var modul4_7 = 0
        var modul8_10 = 0
        var modul11_13= 0
        var modul14_15 = 0
        var modul16_17 = 0
    }

    object Ccna2 {
        var ccna2=0
        var modul1_4 = 0
        var modul5_6 = 0
        var modul7_9 = 0
        var modul10_13= 0
        var modul14_16 = 0
    }

    object Ccna3 {
        var ccna3=0
        var modul1_2 = 0
        var modul3_5 = 0
        var modul6_8 = 0
        var modul9_12= 0
        var modul13_14 = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        StatusBarUtil.setTransparent(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val sp1 = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val Ed = sp1.edit()


        prihlaseny = sp1.getInt("prihlaseny", 0)
        Email = sp1.getString("Email", null).toString()



        // stiahnutie mena a pohlavia a progresu pri prihlásení

        val rootRef = FirebaseDatabase.getInstance().reference
        val ordersRef = rootRef.child("Uzivatel").orderByChild("email").equalTo(Email)
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    //ccna1
                    val cislo =ds.child("Ccna1").child("modul_1_3").getValue(Int::class.java)!!
                    val cislo1 =ds.child("Ccna1").child("modul_4_7").getValue(Int::class.java)!!
                    val cislo2 =ds.child("Ccna1").child("modul_8_10").getValue(Int::class.java)!!
                    val cislo3 =ds.child("Ccna1").child("modul_11_13").getValue(Int::class.java)!!
                    val cislo4 =ds.child("Ccna1").child("modul_14_15").getValue(Int::class.java)!!
                    val cislo5 =ds.child("Ccna1").child("modul_16_17").getValue(Int::class.java)!!
                    Ed.putInt("Modul1", cislo)
                    Ed.putInt("Modul2", cislo1)
                    Ed.putInt("Modul3", cislo2)
                    Ed.putInt("Modul4", cislo3)
                    Ed.putInt("Modul5", cislo4)
                    Ed.putInt("Modul6", cislo5)

                    //ccna2
                    val cislo6 =ds.child("Ccna2").child("modul_1_4").getValue(Int::class.java)!!
                    val cislo7 =ds.child("Ccna2").child("modul_5_6").getValue(Int::class.java)!!
                    val cislo8 =ds.child("Ccna2").child("modul_7_9").getValue(Int::class.java)!!
                    val cislo9 =ds.child("Ccna2").child("modul_10_13").getValue(Int::class.java)!!
                    val cislo10 =ds.child("Ccna2").child("modul_14_16").getValue(Int::class.java)!!

                    Ed.putInt("Modul7", cislo6)
                    Ed.putInt("Modul8", cislo7)
                    Ed.putInt("Modul9", cislo8)
                    Ed.putInt("Modul10", cislo9)
                    Ed.putInt("Modul11", cislo10)

                    //ccna3
                    val cislo11 =ds.child("Ccna3").child("modul_1_2").getValue(Int::class.java)!!
                    val cislo12 =ds.child("Ccna3").child("modul_3_5").getValue(Int::class.java)!!
                    val cislo13 =ds.child("Ccna3").child("modul_6_8").getValue(Int::class.java)!!
                    val cislo14 =ds.child("Ccna3").child("modul_9_12").getValue(Int::class.java)!!
                    val cislo15 =ds.child("Ccna3").child("modul_13_14").getValue(Int::class.java)!!

                    Ed.putInt("Modul12", cislo11)
                    Ed.putInt("Modul13", cislo12)
                    Ed.putInt("Modul14", cislo13)
                    Ed.putInt("Modul15", cislo14)
                    Ed.putInt("Modul16", cislo15)


                    val username = ds.child("username").getValue(String::class.java)
                    if (username != null) {
                        Ed.putString("Name", username)
                        Ed.apply()
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.d(ContentValues.TAG, databaseError.message) //Don't ignore errors!
            }
        }

        ordersRef.addListenerForSingleValueEvent(valueEventListener)


        val handler = Handler()
            handler.postDelayed({
                this.finish()
                val intent = Intent(this, MainActivity::class.java).apply {
                }
                startActivity(intent)
            }, 700)
    }



}