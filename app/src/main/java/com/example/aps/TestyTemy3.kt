package com.example.aps

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aps.TestyTemy3.cisloJson3.number
import com.jaeger.library.StatusBarUtil

class TestyTemy3 : AppCompatActivity() {


    internal lateinit var myDialog: Dialog
    internal lateinit var txt: ImageView

    object cisloJson3 {
        var number: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testy_temy3)
        setSupportActionBar(findViewById(R.id.toolbar))
        val actionbar = supportActionBar
        actionbar!!.title = "Témy  kurz CCNA 3"
        actionbar.setDisplayHomeAsUpEnabled(true)

        TestyTemy1.cisloJson1.number=0
        TestyTemy2.cisloJson2.number=0

       val button = findViewById<View>(R.id.button1_3) as View
        button.setOnClickListener {
            ShowDialog()
            number =12
        }
       val button1 = findViewById<View>(R.id.button2_3) as View
        button1.setOnClickListener {
            ShowDialog()
            number =13
        }
        val button2 = findViewById<View>(R.id.button3_3) as View
        button2.setOnClickListener {
            ShowDialog()
            number =14
        }
       val button3 = findViewById<View>(R.id.button4_3) as View
        button3.setOnClickListener {
            ShowDialog()
            number =15
        }
       val button4 = findViewById<View>(R.id.button5_3) as View
        button4.setOnClickListener {
            ShowDialog()
            number =16
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