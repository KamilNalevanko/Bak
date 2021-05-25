package com.example.aps

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aps.TestyTemy2.cisloJson2.number
import com.jaeger.library.StatusBarUtil

class TestyTemy2 : AppCompatActivity() {


    internal lateinit var myDialog: Dialog
    internal lateinit var txt: ImageView

    object cisloJson2 {
        var number: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testy_temy2)
        setSupportActionBar(findViewById(R.id.toolbar))
        val actionbar = supportActionBar
        actionbar!!.title = "Témy kurz CCNA 2"
        actionbar.setDisplayHomeAsUpEnabled(true)

        TestyTemy3.cisloJson3.number=0
        TestyTemy1.cisloJson1.number=0

        val button = findViewById<View>(R.id.button1_2) as View
        button.setOnClickListener {
            ShowDialog()
            number = 7
            Log.d("cislo je "+ TestyTemy2.cisloJson2.number, "tak vyslo")
        }
        val button1 = findViewById<View>(R.id.button2_2) as View
        button1.setOnClickListener {
            ShowDialog()
            number = 8
            Log.d("cislo je "+ TestyTemy2.cisloJson2.number, "tak vyslo")
        }
        val button2 = findViewById<View>(R.id.button3_2) as View
        button2.setOnClickListener {
            ShowDialog()
            number = 9
            Log.d("cislo je "+ TestyTemy2.cisloJson2.number, "tak vyslo")
        }
        val button3 = findViewById<View>(R.id.button4_2) as View
        button3.setOnClickListener {
            ShowDialog()
            number = 10
            Log.d("cislo je "+ TestyTemy2.cisloJson2.number, "tak vyslo")
        }
        val button4 = findViewById<View>(R.id.button5_2) as View
        button4.setOnClickListener {
            ShowDialog()
            number = 11
            Log.d("cislo je "+ TestyTemy2.cisloJson2.number, "tak vyslo")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun MalyTest(view: View){
        val intent = Intent(this, Testy::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        TestyTemy1.test.kratky=true
        intent.putExtra("testSize", 10)
        myDialog.cancel()
        Testy.results.correctAnswer =0
        Testy.results.wrongAnswer =0
        startActivity(intent)
    }
    fun VelkyTest(view: View){
        val intent = Intent(this, Testy::class.java).apply { // tu mozem testy alebo tak davat na prekľik
        }
        TestyTemy1.test.dlhy=true
        intent.putExtra("testSize", 20)
        myDialog.cancel()
        Testy.results.correctAnswer =0
        Testy.results.wrongAnswer =0
        startActivity(intent)

    }


    fun ShowDialog() {
        myDialog = Dialog(this)
        myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        myDialog.setContentView(R.layout.vyskakovacie)
        myDialog.setCancelable(true)
        txt = myDialog.findViewById<ImageView>(R.id.krizik) as ImageView
        //txt.isEnabled = true
        txt.setOnClickListener {
            Toast.makeText(applicationContext, "Zavrieť", Toast.LENGTH_LONG).show()
            myDialog.cancel()

        }
        myDialog.show()
    }

}