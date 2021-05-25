package com.example.aps

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.aps.Testy.results.correctAnswer
import com.example.aps.Testy.results.wrongAnswer
import com.example.aps.TestyTemy1.cisloJson1.number
import com.jaeger.library.StatusBarUtil

class TestyTemy1 : AppCompatActivity() {


    internal lateinit var myDialog: Dialog
    internal lateinit var txt: ImageView

    object cisloJson1 {
        var number: Int = 0
    }

    object test {
        var dlhy: Boolean = false
        var kratky: Boolean = false
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testy_temy)
        setSupportActionBar(findViewById(R.id.toolbar))
        val actionbar = supportActionBar
        actionbar!!.title = "Témy kurz CCNA 1"
        actionbar.setDisplayHomeAsUpEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }

        TestyTemy3.cisloJson3.number=0
        TestyTemy2.cisloJson2.number=0
        val button = findViewById<View>(R.id.button1_1) as View
        button.setOnClickListener {
            ShowDialog()
            number=1
            Log.d("cislo je "+ number, "tak vyslo")
        }

        val button1 = findViewById<View>(R.id.button2_1) as View
          button1.setOnClickListener {
         ShowDialog()
         number=2
              Log.d("cislo je "+ number, "tak vyslo")
         }

         val button2 = findViewById<View>(R.id.button3_1) as View
         button2.setOnClickListener {
             ShowDialog()
             number=3
             Log.d("cislo je "+ number, "tak vyslo")
         }

          val button3 = findViewById<View>(R.id.button4_1) as View
           button3.setOnClickListener {
             ShowDialog()
             number=4
               Log.d("cislo je "+ number, "tak vyslo")
         }
         val button4 = findViewById<View>(R.id.button5_1) as View
         button4.setOnClickListener {
             ShowDialog()
             number=5
             Log.d("cislo je "+ number, "tak vyslo")
         }
        val button5 = findViewById<View>(R.id.button6_1) as View
         button5.setOnClickListener {
             ShowDialog()
             number=6
             Log.d("cislo je "+ number, "tak vyslo")
         }

}

fun ShowDialog(){
 myDialog = Dialog(this)
 myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
 myDialog.setContentView(R.layout.vyskakovacie)
 myDialog.setCancelable(true)
 txt=myDialog.findViewById<ImageView>(R.id.krizik) as ImageView
 //txt.isEnabled = true
 txt.setOnClickListener {
     Toast.makeText(applicationContext, "Zavrieť",Toast.LENGTH_LONG).show()
     myDialog.cancel()
 }
 myDialog.show()
}

override fun onSupportNavigateUp(): Boolean {
 onBackPressed()
 return true
}
fun MalyTest(view: View){
 val intent = Intent(this, Testy::class.java).apply { // tu mozem testy alebo tak davat na prekľik
 }
 test.kratky=true
 intent.putExtra("testSize", 10)
 myDialog.cancel()
  correctAnswer=0
  wrongAnswer=0
 startActivity(intent)
}
fun VelkyTest(view: View){
 val intent = Intent(this, Testy::class.java).apply { // tu mozem testy alebo tak davat na prekľik
 }
 test.dlhy=true
 intent.putExtra("testSize", 20)
 myDialog.cancel()
 correctAnswer=0
 wrongAnswer=0
 startActivity(intent)

}

}
