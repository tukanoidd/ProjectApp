package org.tukanoid.projectapp

import android.content.pm.ActivityInfo
import android.content.res.Resources
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_quiz.*
import org.tukanoid.projectapp.quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var quiz: Quiz
    private lateinit var quizToShow: Map<String, Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        InitQuiz()
        chooseQuestions()
    }

    fun InitQuiz() {
        quiz = Quiz(
            mapOf(
                Pair(
                    "mercury",
                    PlanetData(
                        listOf(
                            Question(
                                "question",
                                listOf(
                                    Answer("1", true),
                                    Answer("2", false),
                                    Answer("3", false),
                                    Answer("4", false)
                                )
                            )
                        )
                    )
                )
            )
        )
    }

    fun chooseQuestions() {
        val planets: List<String> =
            listOf("mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune")
        val planetsBackgrounds: Map<String, Int> = mapOf(
            Pair("mercury", R.drawable.mercury_space_background),
            Pair("venus", R.drawable.venus_space_background),
            Pair("earth", R.drawable.earth_space_background),
            Pair("mars", R.drawable.mars_space_background),
            Pair("jupiter", R.drawable.jupiter_space_background),
            Pair("saturn", R.drawable.saturn_space_background),
            Pair("uranus", R.drawable.uranus_space_background),
            Pair("neptune", R.drawable.neptune_space_background)
        )
        val planetsIMGs: Map<String, Int> = mapOf(
            Pair("mercury", R.drawable.mercury),
            Pair("venus", R.drawable.venus),
            Pair("earth", R.drawable.earth),
            Pair("mars", R.drawable.mars),
            Pair("jupiter", R.drawable.jupiter),
            Pair("saturn", R.drawable.saturn),
            Pair("uranus", R.drawable.uranus),
            Pair("neptune", R.drawable.neptune)
        )
        val planetsColors: Map<String, Int> = mapOf(
            Pair("mercury", R.color.mercuryList),
            Pair("venus", R.color.venusList),
            Pair("earth", R.color.earthList),
            Pair("mars", R.color.marsList),
            Pair("jupiter", R.color.jupiterList),
            Pair("saturn", R.color.saturnList),
            Pair("uranus", R.color.uranusList),
            Pair("neptune", R.color.neptuneList)
        )
        val planetsBtnsWrong: Map<String, Int> = mapOf(
            Pair("mercury", R.drawable.mercury_button_wrong),
            Pair("venus", R.drawable.venus_button_wrong),
            Pair("earth", R.drawable.earth_button_wrong),
            Pair("mars", R.drawable.mars_button_wrong),
            Pair("jupiter", R.drawable.jupiter_button_wrong),
            Pair("saturn", R.drawable.saturn_button_wrong),
            Pair("uranus", R.drawable.uranus_button_wrong),
            Pair("neptune", R.drawable.neptune_button_wrong)
        )
        val planetsBtnsRight: Map<String, Int> = mapOf(
            Pair("mercury", R.drawable.mercury_button_right),
            Pair("venus", R.drawable.venus_button_right),
            Pair("earth", R.drawable.earth_button_right),
            Pair("mars", R.drawable.mars_button_right),
            Pair("jupiter", R.drawable.jupiter_button_right),
            Pair("saturn", R.drawable.saturn_button_right),
            Pair("uranus", R.drawable.uranus_button_right),
            Pair("neptune", R.drawable.neptune_button_right)
        )

        quizToShow = mapOf(
            Pair(planets[0], quiz.planetData.getValue(planets[0]).questionsAnswers[0])
        )

        val ansBtnList: MutableList<ButtonDataClass> = mutableListOf()

        mainQuizLayout.setBackgroundResource(planetsBackgrounds.getValue(planets[0]))

        val ans_container_shape = GradientDrawable()
        ans_container_shape.setColor(getColor(planetsColors.getValue(planets[0])))
        ans_container_shape.cornerRadius = 25F
        ans_container_shape.alpha = 176
        answersList.background = ans_container_shape

        planetName.text = planets[0]
        planetImage.setImageResource(planetsIMGs.getValue(planets[0]))
        questionText.text = quizToShow.getValue(planets[0]).question

        for (i in 0..3) {
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.height = 135

            if (i == 0) params.setMargins(5, 10, 5, 20)
            if (i == 3) params.setMargins(5, 20, 5, 10)
            else params.setMargins(5, 20, 5, 20)

            val ans = ButtonDataClass(Button(this), quizToShow.getValue(planets[0]).answers[i].isRight)
            ans.btn.layoutParams = params
            ans.btn.setBackgroundResource(R.color.white)
            ans.btn.text = quizToShow.getValue(planets[0]).answers[i].text
            ans.btn.setTextColor(getColor(R.color.quizBtnTextColor))
            ans.btn.typeface = resources.getFont(R.font.myriadpro_regular)
            ans.btn.textSize = 16F

            ansBtnList.add(ans)

            answersList.addView(ans.btn)
        }

        for (ans in ansBtnList) {
            ans.btn.setOnClickListener {
                if (ans.right) ans.btn.setBackgroundResource(planetsBtnsRight.getValue(planets[0]))
                else ans.btn.setBackgroundResource(planetsBtnsWrong.getValue(planets[0]))

                for (ans2 in ansBtnList) ans2.btn.isClickable = false

                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                params.setMargins(5, 20, 5, 20); ansBtnList[ansBtnList.size - 1].btn.layoutParams = params
                val nextBtn = Button(this)
                params.setMargins(5, 20, 5, 10)
                params.height = 135
                nextBtn.layoutParams = params
                nextBtn.text = getText(R.string.next_btn_text)
                nextBtn.setTextColor(getColor(R.color.white))
                nextBtn.typeface = resources.getFont(R.font.myriadpro_regular)
                nextBtn.textSize = 16F
                nextBtn.setBackgroundColor(getColor(planetsColors.getValue(planets[0])))
                nextBtn.background.alpha = 180
                nextBtn.setPadding(5, 3, 5, 3)

                answersList.addView(nextBtn)
            }
        }
    }
}
