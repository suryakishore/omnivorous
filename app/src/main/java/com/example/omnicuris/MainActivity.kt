package com.example.omnicuris

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView

/**
 * this activity is used to show the questions.
 */
class MainActivity : AppCompatActivity() {
    private var list = ArrayList<Question>()
    lateinit var tvQuestion: AppCompatTextView
    lateinit var tvQuestionCount: AppCompatTextView

    lateinit var radioButton1: RadioButton
    lateinit var radioButton2: RadioButton
    lateinit var radioButton3: RadioButton
    lateinit var radioButton4: RadioButton
    lateinit var tvSubmit: AppCompatTextView
    lateinit var radioGroup: RadioGroup
    var index: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViewIds()
        setOnclickSubmit();
        getQuestions();
        showQuestion(index)
    }

    /**
     * get the view ids
     */
    private fun getViewIds() {
        tvQuestion = findViewById(R.id.tvQuestion)
        tvQuestionCount = findViewById(R.id.tvQuestionCount)

        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        radioButton3 = findViewById(R.id.radioButton3)
        radioButton4 = findViewById(R.id.radioButton4)
        tvSubmit = findViewById(R.id.tvSubmit)
        radioGroup = findViewById(R.id.radioGroup)

    }

    /**
     * show question at particular index.
     */
    private fun showQuestion(index: Int) {

        tvQuestionCount.setText("(" + index + "/" + list.size + ")")

        val question = list.get(index);

        tvQuestion.setText(question.question)
        radioButton1.setText(question.option1)
        radioButton2.setText(question.option2)
        radioButton3.setText(question.option3)
        radioButton4.setText(question.option4)


    }

    /**
     * add the questions into the question objects into the arraylist
     */
    private fun getQuestions() {


        val question1 = Question()

        question1.question = "who is the prime minister of karantaka?"
        question1.option1 = "narendra modi"
        question1.option2 = "mamatha benarji"
        question1.option3 = "sathish"
        question1.option4 = "rajesh"
        question1.correctAnswer = "narendra modi"

        val question2 = Question()

        question2.question = "who is the chief minister of karantaka?"
        question2.option1 = "yadurappa"
        question2.option2 = "mamatha benarji"
        question2.option3 = "sathish"
        question2.option4 = "rajesh"
        question2.correctAnswer = "yadurappa"


        val question3 = Question()

        question3.question = "who is the chief minister of andhra pradhesh?"
        question3.option1 = "jagan"
        question3.option2 = "chandrababu naidu"
        question3.option3 = "sathish"
        question3.option4 = "rajesh"
        question3.correctAnswer = "jagan"

        val question4 = Question()

        question4.question = "who wrote national anthem?"
        question4.option1 = "ravindhra nath tagore"
        question4.option2 = "mamatha benarji"
        question4.option3 = "sathish"
        question4.option4 = "rajesh"
        question4.correctAnswer = "ravindhra nath tagore"
        list.add(question1)
        list.add(question2)
        list.add(question3)
        list.add(question4)

    }

    /**
     * add onclick listener for the submit.
     */
    private fun setOnclickSubmit() {


        tvSubmit.setOnClickListener(View.OnClickListener {
            if (radioButton1.isChecked) {
                val question = list.get(index);
                question.yourAnswer = radioButton1.text.toString()
                if (question.correctAnswer!!.equals(radioButton1.text)) {
                    question.isSelectedCorrect = true;

                } else
                    question.isSelectedCorrect = false;


            } else if (radioButton2.isChecked) {
                val question = list.get(index);
                question.yourAnswer = radioButton2.text.toString()

                if (question.correctAnswer!!.equals(radioButton2.text)) {
                    question.isSelectedCorrect = true;

                } else
                    question.isSelectedCorrect = false;

            } else if (radioButton3.isChecked) {
                val question = list.get(index);
                question.yourAnswer = radioButton3.text.toString()

                if (question.correctAnswer!!.equals(radioButton3.text)) {
                    question.isSelectedCorrect = true;

                } else
                    question.isSelectedCorrect = false;
            } else if (radioButton4.isChecked) {
                val question = list.get(index);
                question.yourAnswer = radioButton4.text.toString()
                if (question.correctAnswer!!.equals(radioButton4.text)) {
                    question.isSelectedCorrect = true;

                } else
                    question.isSelectedCorrect = false;

            } else {
                Toast.makeText(
                    applicationContext,
                    resources.getString(R.string.selectanswer),
                    Toast.LENGTH_SHORT
                )
                    .show()

            }
            if (radioButton1.isChecked || radioButton2.isChecked || radioButton3.isChecked || radioButton4.isChecked) {

                radioGroup.clearCheck()
                ++index;
                Log.d("exe", "index" + index)
                if (index < 4)
                    showQuestion(index)
                else {

                    val intent = Intent(this, ShowAnswersActivity::class.java)
                    intent.putExtra("questions", list)
                    startActivity(intent)
                    index = 0;
                    radioGroup.clearCheck()
                    showQuestion(index)

                }
            }


        })


    }


}
