package com.example.aps

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import com.example.aps.Testy.results.correctAnswer
import com.example.aps.Testy.results.percentages
import com.example.aps.Testy.results.wrongAnswer
import com.example.aps.tests.QuestionsList
import com.google.gson.Gson
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.content_testy.*
import java.io.IOException
import java.io.InputStream
import java.nio.charset.StandardCharsets


class Testy : AppCompatActivity() {

    var questionsList = QuestionsList()
    var s_question = 0
    var randomAnswers: IntArray = intArrayOf(0,1,2,3)
    var max_questions=0
    var randomQuestion: MutableList<Int> = mutableListOf<Int>()
    var currentQuestion = 0


    object results {
        var correctAnswer: Int=0
        var wrongAnswer: Int=0
        var percentages =0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testy)
        setSupportActionBar(findViewById(R.id.toolbar))
        var jsonString = getAssetsJSON("CCNA1_4-7.json")
        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Test"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        StatusBarUtil.setTransparent(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.parseColor("#407d59")
        }


        val message = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE)

        max_questions = intent.getIntExtra("testSize", 10)// zmenit na 10 spať

        Log.d("max_questions","MQ: "+max_questions)

        if (message != null) {
            Log.d("sprava",message)
        }

        if(TestyTemy1.cisloJson1.number==1){
            jsonString=getAssetsJSON("CCNA1_1-3.json")
        }
        if(TestyTemy1.cisloJson1.number==2){
            jsonString=getAssetsJSON("CCNA1_4-7.json")
        }
        if(TestyTemy1.cisloJson1.number==3){
            jsonString=getAssetsJSON("CCNA1_8-10.json")
        }
        if(TestyTemy1.cisloJson1.number==4){
            jsonString=getAssetsJSON("CCNA1_11-13.json")
        }
        if(TestyTemy1.cisloJson1.number==5){
            jsonString=getAssetsJSON("CCNA1_14-15.json")
        }
        if(TestyTemy1.cisloJson1.number==6){
            jsonString=getAssetsJSON("CCNA1_16-17.json")
        }
        if(TestyTemy2.cisloJson2.number==7){
            jsonString=getAssetsJSON("CCNA2_1-4.json")
        }
        if(TestyTemy2.cisloJson2.number==8){
            jsonString=getAssetsJSON("CCNA2_5-6.json")
        }
        if(TestyTemy2.cisloJson2.number==9){
            jsonString=getAssetsJSON("CCNA2_7-9.json")
        }
        if(TestyTemy2.cisloJson2.number==10){
            jsonString=getAssetsJSON("CCNA2_10-13.json")
        }
        if(TestyTemy2.cisloJson2.number==11){
            jsonString=getAssetsJSON("CCNA2_14-16.json")
        }
        if(TestyTemy3.cisloJson3.number==12){
            jsonString=getAssetsJSON("CCNA3_12.json")
        }
        if(TestyTemy3.cisloJson3.number==13){
            jsonString=getAssetsJSON("CCNA3_3-5.json")
        }
        if(TestyTemy3.cisloJson3.number==14){
            jsonString=getAssetsJSON("CCNA3_6-8.json")
        }
        if(TestyTemy3.cisloJson3.number==15){
            jsonString=getAssetsJSON("CCNA3_9-12.json")
        }
        if(TestyTemy3.cisloJson3.number==16){
            jsonString=getAssetsJSON("CCNA3_13-14.json")
        }


        val text = findViewById<View>(R.id.textView23) as TextView
        text.text = "0" + "/" +max_questions.toString()
        text.setTextColor(Color.parseColor("#FFFFFF"))
        val gson = Gson()
        questionsList = gson.fromJson<QuestionsList>(jsonString, QuestionsList::class.java)

        Log.d("Test", "Count: "+questionsList.QuestionList.size)
        Log.d("Test", "text: "+questionsList.QuestionList[0].QuestionText)

        for (i in 0..questionsList.QuestionList.size-1)
        {
            randomQuestion.add(i)
        }

        for (i in 0..questionsList.QuestionList.size-1)
        {
            val x = randomQuestion.get(i)
            val rnds = (0..questionsList.QuestionList.size-1).random()
            val y = randomQuestion.get(rnds)

            randomQuestion.set(i, y)
            randomQuestion.set(rnds, x)
        }


        randomQuestion.forEach { Log.d("QUESTION LIST", "LIST: "+it) }


        val nextButton = findViewById<ImageButton>(R.id.imageButtonTestyNext)
        nextButton.setOnClickListener {
            currentQuestion++
            randomizeAnswers()
            prepareTest(max_questions) // som pridal premennu max questions 10 abo 20
            nextButton.visibility = GONE

            progressBar.max= max_questions

            var currentProgress = 0
            currentProgress=currentQuestion

            val text = findViewById<View>(R.id.textView23) as TextView
            text.text = currentProgress.toString()+ "/" +max_questions.toString()
            text.setTextColor(Color.parseColor("#FFFFFF"))
            ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
                .start()

            if(currentQuestion==(max_questions)) {
                val intent = Intent(this, Win::class.java).apply { // tu mozem testy alebo tak davat na prekľik
                     percentages = (correctAnswer*100)/max_questions

                }

                startActivity(intent)
                finish()
            }
        }


        randomizeAnswers()
        prepareTest(max_questions)



    }




    fun randomizeAnswers()
    {
        for(i in 0..3)
        {
            val x = randomAnswers.get(i)
            val rnds = (0..3).random()
            val y = randomAnswers.get(rnds)

            randomAnswers.set(i, y)
            randomAnswers.set(rnds, x)
        }
    }



    fun changeColor(button: AppCompatRadioButton, rcolor: Int)
    {
        val color = ContextCompat.getColor(this, rcolor)

        button.setTextColor(color)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.buttonTintList = ColorStateList.valueOf(color)
        }
        button.highlightColor = color

        button.jumpDrawablesToCurrentState()
    }


    fun answerSelected(button: AppCompatRadioButton, answer: Int)
    {
        Log.d("SelectedAnswer", "Selected: "+questionsList.QuestionList[s_question].AnswerList[answer].AnswerText)

        findViewById<ImageButton>(R.id.imageButtonTestyNext).visibility = VISIBLE

        if(questionsList.QuestionList[s_question].AnswerList[answer].Correct){

            changeColor(button, R.color.lightgreen)
            correctAnswer++


        }else{
            Log.d("WrongAnswer","Answer is wrong!")

            changeColor(button, R.color.lightred)
            wrongAnswer++

            val panel = findViewById<LinearLayout>(R.id.answer_panel)

            val childCount = panel.childCount
            for (i in 0 until childCount) {
                val rb: AppCompatRadioButton = panel.getChildAt(i) as AppCompatRadioButton
                if(questionsList.QuestionList[s_question].AnswerList[randomAnswers[i]].Correct)
                {
                    changeColor(rb, R.color.lightgreen)
                }
            }

        }
        val panel = findViewById<LinearLayout>(R.id.answer_panel)
        val childCount = panel.childCount
        for (i in 0 until childCount) {
            val child: View = panel.getChildAt(i)
            child.isEnabled = false
        }


    }

    fun getQuestion(): Int {
        return randomQuestion.get(currentQuestion)
    }


    fun prepareTest(maxquestions: Int){

        s_question = currentQuestion
        if(s_question>max_questions) Log.d("test","koniec")
        val panel = findViewById<LinearLayout>(R.id.answer_panel)
        panel.removeAllViews()
        findViewById<TextView>(R.id.textView_question).text = questionsList.QuestionList[getQuestion()].QuestionText

        for (i in 0..3) {
            val button = AppCompatRadioButton(this)
            button.textSize = 18f
            button.setTextColor(Color.parseColor("#FFFFFF"))
            changeColor(button, R.color.colorWhite)
            // margin odpovedi
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(15,28,15,0)

            button.layoutParams = params

            button.text = questionsList.QuestionList[getQuestion()].AnswerList[randomAnswers[i]].AnswerText
            button.setOnClickListener {
                answerSelected(button, randomAnswers[i])
            }
            panel.addView(button)
        }

    }


    /* Get File in Assets Folder */
    fun getAssetsJSON(fileName: String?): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = this.assets.open(fileName!!)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, StandardCharsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return json
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        finish()
        return true
    }


}