package com.example.aps



import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.aps.Testy.results.correctAnswer
import com.example.aps.Testy.results.percentages
import com.example.aps.Testy.results.wrongAnswer
import com.google.firebase.database.*
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_win.*


class Win : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        StatusBarUtil.setTransparent(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)
        if (percentages > 50){
            Log.d("SelectedAnswer", "Selected: $percentages")
            window.decorView.setBackgroundColor(Color.rgb(32, 142, 78))
            button3.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorGreen),
                PorterDuff.Mode.MULTIPLY
            )
        }
        if (percentages <  51){
            Log.d("SelectedAnswer", "Selected: $percentages")
            window.decorView.setBackgroundColor(Color.rgb(173, 45, 48))
            button3.background.setColorFilter(
                ContextCompat.getColor(this, R.color.colorAccent),
                PorterDuff.Mode.MULTIPLY
            )
        }

        var questions=0
        var percentage=0

        if (TestyTemy1.test.dlhy){
            questions = 20
        }
        if (TestyTemy1.test.kratky){
            questions = 10
        }

        percentage = (correctAnswer*100)/questions

        val textView = findViewById<View>(R.id.textView4) as TextView
        textView.text = "Nesprávne odpovede : " + wrongAnswer+"/"+questions

        val textView2 = findViewById<View>(R.id.textView3) as TextView
        textView2.text = "Správne odpovede : " + correctAnswer+"/"+questions


        val textView3 = findViewById<View>(R.id.textView5) as TextView
        textView3.text = "Úspešnosť : " + percentage + "%"

    //    Log.d("Cislo pre temy1: "+ TestyTemy1.cisloJson1.number, "Cislo pre temy2 " +TestyTemy2.cisloJson2.number)
        // ulozisko aplikacie
        val sp1 = getSharedPreferences("Login", Context.MODE_PRIVATE)
        Profil.profil.Id=sp1.getString("user_id", null).toString()
        val Ed = sp1.edit()
        // pre Ccna1
        if (TestyTemy1.cisloJson1.number in 1..6){

            if(TestyTemy1.cisloJson1.number==1){
                Ed.putInt("Modul1", percentage)
            }
            if(TestyTemy1.cisloJson1.number==2){
                Ed.putInt("Modul2", percentage)
            }
            if(TestyTemy1.cisloJson1.number==3){
                Ed.putInt("Modul3", percentage)
            }
            if(TestyTemy1.cisloJson1.number==4){
                Ed.putInt("Modul4", percentage)
            }
            if(TestyTemy1.cisloJson1.number==5){
                Ed.putInt("Modul5", percentage)
            }
            if(TestyTemy1.cisloJson1.number==6){
                Ed.putInt("Modul6", percentage)
            }
            Ed.apply()
        }
        // pre Ccna1


        // pre Ccna2
        if (TestyTemy2.cisloJson2.number in 7..11){
            if(TestyTemy2.cisloJson2.number==7){
                Ed.putInt("Modul7", percentage)
            }
            if(TestyTemy2.cisloJson2.number==8){
                Ed.putInt("Modul8", percentage)
            }
            if(TestyTemy2.cisloJson2.number==9){
                Ed.putInt("Modul9", percentage)
            }
            if(TestyTemy2.cisloJson2.number==10){
                Ed.putInt("Modul10", percentage)
            }
            if(TestyTemy2.cisloJson2.number==11){
                Ed.putInt("Modul11", percentage)
            }
            Ed.apply()
        }

        // pre Ccna3
        if (TestyTemy3.cisloJson3.number in 12..16){
            if(TestyTemy3.cisloJson3.number==12){
                Ed.putInt("Modul12", percentage)
            }
            if(TestyTemy3.cisloJson3.number==13){
                Ed.putInt("Modul13", percentage)
            }
            if(TestyTemy3.cisloJson3.number==14){
                Ed.putInt("Modul14", percentage)
            }
            if(TestyTemy3.cisloJson3.number==15){
                Ed.putInt("Modul15", percentage)
            }
            if(TestyTemy3.cisloJson3.number==16){
                Ed.putInt("Modul16", percentage)
            }
            Ed.apply()

        }




    }

    fun Potvrdit(view: View){
        val intent = Intent(this, MainActivity::class.java).apply { // tu mozem testy alebo tak davat na prekľik
            Testy.results.correctAnswer = 0
            Testy.results.wrongAnswer = 0
            TestyTemy1.test.dlhy=false
            TestyTemy1.test.kratky=false
        }
        startActivity(intent)
        finish()

    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java).apply {
            Testy.results.correctAnswer = 0
            Testy.results.wrongAnswer = 0
            TestyTemy1.test.dlhy = false
            TestyTemy1.test.kratky = false
        }
        startActivity(intent)
        finish()
    }
}