package com.example.aps

import android.app.ActionBar
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.aps.Login.prihlaseny.logged
import com.example.aps.Profil.profil.prihlaseny
import com.example.aps.functions.CustomEvent
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_ccna1_postup.*
import kotlinx.android.synthetic.main.activity_register.*


class MainActivity : AppCompatActivity() {



    private lateinit var appBarConfiguration: AppBarConfiguration

    var events = mutableListOf<CustomEvent>()

    override fun onCreate(savedInstanceState: Bundle?) {

        StatusBarUtil.setTransparent(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }


        // automaticke prihlásenie
        val sp1 = getSharedPreferences("Login", Context.MODE_PRIVATE)
        prihlaseny = sp1.getInt("prihlaseny", 0)
        Profil.profil.Email = sp1.getString("Email", null).toString()
        Profil.profil.name=sp1.getString("Name",null).toString()
        Profil.profil.gender=sp1.getInt("Pohlavie",0)
        if(prihlaseny!=2){
            if(sp1.getBoolean("Verified", false)){logged=true}} /*
        FirebaseAuth.getInstance().signInWithEmailAndPassword(Profil.profil.Email,Profil.profil.Pass).addOnCompleteListener{ task-> logged=true}}}*/



        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_tests, R.id.nav_teoria, R.id.nav_konfiguracia,R.id.nav_profile), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



        // stiahnute udajov progresu zo shared preference do premennych v programe

        val Ed = sp1.edit()
        Ed.putString("Name", Profil.profil.name)
        Ed.apply()
        Profil.profil.name=sp1.getString("Name", null).toString()
        // ccna1 od 1 do 6
        Profil.Ccna1.modul1_3 = sp1.getInt("Modul1", 0)
        Profil.Ccna1.modul4_7=sp1.getInt("Modul2", 0)
        Profil.Ccna1.modul8_10=sp1.getInt("Modul3", 0)
        Profil.Ccna1.modul11_13=sp1.getInt("Modul4", 0)
        Profil.Ccna1.modul14_15=sp1.getInt("Modul5", 0)
        Profil.Ccna1.modul16_17=sp1.getInt("Modul6", 0)

        //ccna2 od 7 do 11
        Profil.Ccna2.modul1_4=sp1.getInt("Modul7", 0)
        Profil.Ccna2.modul5_6=sp1.getInt("Modul8", 0)
        Profil.Ccna2.modul7_9=sp1.getInt("Modul9", 0)
        Profil.Ccna2.modul10_13=sp1.getInt("Modul10", 0)
        Profil.Ccna2.modul14_16=sp1.getInt("Modul11", 0)
        //ccna3 od 12 do 16
        Profil.Ccna3.modul1_2=sp1.getInt("Modul12", 0)
        Profil.Ccna3.modul3_5=sp1.getInt("Modul13", 0)
        Profil.Ccna3.modul6_8=sp1.getInt("Modul14", 0)
        Profil.Ccna3.modul9_12=sp1.getInt("Modul15", 0)
        Profil.Ccna3.modul13_14=sp1.getInt("Modul16", 0)

        if(Login.prihlaseny.logged) {
            // zaslanie udajov pri wifi pripojeni do databazy

            val mDatabase = FirebaseDatabase.getInstance().getReference("Uzivatel")
                .child(sp1.getString("user_id", null).toString())
            mDatabase.child("Ccna1").child("modul_1_3").setValue(sp1.getInt("Modul1", 0))
            mDatabase.child("Ccna1").child("modul_4_7").setValue(sp1.getInt("Modul2", 0))
            mDatabase.child("Ccna1").child("modul_8_10").setValue(sp1.getInt("Modul3", 0))
            mDatabase.child("Ccna1").child("modul_11_13").setValue(sp1.getInt("Modul4", 0))
            mDatabase.child("Ccna1").child("modul_14_15").setValue(sp1.getInt("Modul5", 0))
            mDatabase.child("Ccna1").child("modul_16_17").setValue(sp1.getInt("Modul6", 0))
            //ccna2
            mDatabase.child("Ccna2").child("modul_1_4").setValue(sp1.getInt("Modul7", 0))
            mDatabase.child("Ccna2").child("modul_5_6").setValue(sp1.getInt("Modul8", 0))
            mDatabase.child("Ccna2").child("modul_7_9").setValue(sp1.getInt("Modul9", 0))
            mDatabase.child("Ccna2").child("modul_10_13").setValue(sp1.getInt("Modul10", 0))
            mDatabase.child("Ccna2").child("modul_14_16").setValue(sp1.getInt("Modul11", 0))

            //ccna3
            mDatabase.child("Ccna3").child("modul_1_2").setValue(sp1.getInt("Modul12", 0))
            mDatabase.child("Ccna3").child("modul_3_5").setValue(sp1.getInt("Modul13", 0))
            mDatabase.child("Ccna3").child("modul_6_8").setValue(sp1.getInt("Modul14", 0))
            mDatabase.child("Ccna3").child("modul_9_12").setValue(sp1.getInt("Modul15", 0))
            mDatabase.child("Ccna3").child("modul_13_14").setValue(sp1.getInt("Modul16", 0))


        }

    }




    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu.findItem(R.id.search)
        var searchView = searchItem?.actionView as SearchView


        val navButtonsParams =
            ActionBar.LayoutParams(70, 70)
        navButtonsParams.setMargins(10,0,10,10)

        val btnNext = Button(this)
        btnNext.setBackgroundResource(R.drawable.bottom_arrow2)

        val btnPrev = Button(this)
        btnPrev.setBackgroundResource(R.drawable.top_arrow2)

        var searchQuery=""

        (searchView.getChildAt(0) as LinearLayout).addView(btnPrev, navButtonsParams)
        (searchView.getChildAt(0) as LinearLayout).addView(btnNext, navButtonsParams)

        (searchView.getChildAt(0) as LinearLayout).gravity = Gravity.BOTTOM

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))
        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("",false)
                searchItem.collapseActionView()
                searchQuery= "$query"

                Log.d("Seach ENTER","Hľadám $query")

                events.forEach{
                    it.DoEvent("$query")
                }

                Toast.makeText(this@MainActivity,"Hľadám... $query",Toast.LENGTH_LONG).show()

                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {

                events.forEach{
                    it.DoEvent("$query")
                }
                return false
            }

        })
        btnNext.setOnClickListener {

            events.forEach{
                it.DoEvent2("$searchQuery")
            }
        }

        btnPrev.setOnClickListener {
            events.forEach{
                it.DoEvent3("$searchQuery")
            }
        }

        return true

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun OpenTemy1(view: View){
        val intent = Intent(this, TestyTemy1::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
    }
    fun OpenTemy2(view: View){
        val intent = Intent(this, TestyTemy2::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
    }
    fun OpenTemy3(view: View){
        val intent = Intent(this, TestyTemy3::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
    }

    fun OpenPostup1(view: View){
        val intent = Intent(this, Ccna1Postup::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
    }
    fun OpenPostup2(view: View){
        val intent = Intent(this, Ccna2Postup::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
    }
    fun OpenPostup3(view: View){
        val intent = Intent(this, Ccna3Postup::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
    }

    fun OpenRegister(view: View){
        val intent = Intent(this, Register::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
        overridePendingTransition(R.anim.to_right,R.anim.slide_out_left)
    }

    fun OpenLogin(view: View){
        val intent = Intent(this, Login::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        startActivity(intent)
        overridePendingTransition(R.anim.to_right,R.anim.slide_out_left)
    }


    fun Odhlasit(view: View) {
        this.finish()
        val sp = getSharedPreferences("Login", Context.MODE_PRIVATE)
        val Ed = sp.edit()
        Ed.putInt("prihlaseny",2)
        Ed.apply()
        Log.d("  Odhlasil som sa "," a malo by byt 2: "+ prihlaseny)
        logged =false
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(
            this,
            "Odhlásený.",
            Toast.LENGTH_SHORT
        ).show()

        val intent = Intent(this, MainActivity::class.java).apply {
            Log.d("ODHLASUJEM","MORE")// tu mozem testy alebo tak davat na prekľik
        }

        startActivity(intent)
    }

}