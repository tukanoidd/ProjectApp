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
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_quiz.*
import org.tukanoid.projectapp.quiz.Answer
import org.tukanoid.projectapp.quiz.PlanetData
import org.tukanoid.projectapp.quiz.Question
import org.tukanoid.projectapp.quiz.Quiz

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
        val planets: List<String> = listOf("mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune")
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

        quizToShow = mapOf(
            Pair(planets[0], quiz.planetData.getValue(planets[0]).questionsAnswers[0])
        )

        mainQuizLayout.setBackgroundResource(planetsBackgrounds.getValue(planets[0]))

        val ans_container_shape = GradientDrawable()
        ans_container_shape.setColor(getColor(planetsColors.getValue(planets[0])))
        ans_container_shape.cornerRadius = 25F
        answersList.background = ans_container_shape

        planetName.text = planets[0]
        planetImage.setImageResource(planetsIMGs.getValue(planets[0]))
        questionText.text = quizToShow.getValue(planets[0]).question

        for (i in 0..3) {
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

            if (i == 0) params.setMargins(5, 10, 5, 20)
            if (i == 3) params.setMargins(5, 20, 5, 10)
            else params.setMargins(5, 20, 5, 20)

            val ans = Button(this)

            ans.height = answersList.height / 5
            ans.layoutParams = params
            ans.text = quizToShow.getValue(planets[0]).answers[i].text
            ans.setTextColor(getColor(R.color.quizBtnTextColor))
            ans.typeface = resources.getFont(R.font.myriadpro_regular)
            ans.textSize = 20F
            ans.setBackgroundResource(R.color.white)
            ans.setPadding(5, 3, 5, 3)

            answersList.addView(ans)
        }
    }

}
