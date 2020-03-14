package com.example.omnicuris

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

/**
 * activity used to show the final result.
 */
class ShowAnswersActivity : AppCompatActivity() {
    private var list = ArrayList<Question>()
    lateinit var AddLl: LinearLayout
    lateinit var tvYourMarks: AppCompatTextView
    lateinit var ivBackBtn: AppCompatImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_answers)
        AddLl = findViewById(R.id.AddLl);
        tvYourMarks = findViewById(R.id.tvYourMarks);
        ivBackBtn = findViewById(R.id.ivBackBtn);

        getIntentData()

        setOnclick();
    }

    /**
     * used to set the onclick for back imageview.
     */
    private fun setOnclick() {
        ivBackBtn.setOnClickListener(View.OnClickListener {

            finish()

        })
    }

    /**
     * get the intent data for questions
     */
    private fun getIntentData() {

        list.addAll(intent.getParcelableArrayListExtra("questions"))
        showResultData()

    }

    /**
     * show the result for each question.
     *
     */
    private fun showResultData() {
        val linearLayout = AddLl
        linearLayout.removeAllViews()
        val layoutInflater = this.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        var viewInflater: View
        var marks = 0;
        for (i in 0..list.size - 1) {
            var question = list.get(i)
            viewInflater = layoutInflater.inflate(R.layout.item_ansrwers, null)
            val tvQuestion = viewInflater.findViewById<AppCompatTextView>(R.id.tvQuestion)
            val tvQuestionYourAnswer =
                viewInflater.findViewById<AppCompatTextView>(R.id.tvQuestionYourAnswer)
            val tvQuestionCorrectAnswer =
                viewInflater.findViewById<AppCompatTextView>(R.id.tvQuestionCorrectAnswer)
            tvQuestion.setText(question.question)
            tvQuestionYourAnswer.setText(resources.getString(R.string.yourAnswer)+" :" + question.yourAnswer)
            tvQuestionCorrectAnswer.setText(resources.getString(R.string.correctAnswer)+" :"  + question.correctAnswer)
            if (question.yourAnswer.equals(question.correctAnswer)) {
                ++marks
            }

            linearLayout.addView(viewInflater)

        }
        tvYourMarks.setText(resources.getString(R.string.totalScore) + " :" + marks)

    }
}
