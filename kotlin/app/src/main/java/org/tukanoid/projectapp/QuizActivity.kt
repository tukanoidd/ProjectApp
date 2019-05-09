package org.tukanoid.projectapp

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.drawable.GradientDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_quiz.*
import org.tukanoid.projectapp.quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var quiz: Quiz
    private var qNum: Int = 0
    private var correctAnss: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        InitQuiz()
        chooseQuestions()
    }

    fun InitQuiz() {
        quiz = Quiz(
            mutableMapOf(
                Pair(
                    "mercury",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What is the length of Mercury's equatorial radius?",mutableListOf(
                                    Answer("2,439.7 km", true),
                                    Answer("1,893 km", false),
                                    Answer("3,548.2 km", false),
                                    Answer("2,874 km", false)
                                )
                            ),
                            Question(
                                "What is the the name of the largest crater on Mercury?",mutableListOf(
                                    Answer("Ouroboros Basin", false),
                                    Answer("Euronimus", false),
                                    Answer("Caloris Basin", true),
                                    Answer("Carstus", false)
                                )
                            ),
                            Question(
                                "What is the outer crust of Mercury made of?",mutableListOf(
                                    Answer("Rocks", false),
                                    Answer("Silicate", true),
                                    Answer("Sulfur", false),
                                    Answer("Metals", false)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "venus",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What temperatures can be met on the surface of Venus?",mutableListOf(
                                    Answer("Over 400 °C", true),
                                    Answer("Under 300 °C", false),
                                    Answer("Under 400 °C", false),
                                    Answer("Over 500 °C ", false)
                                )
                            ),
                            Question(
                                "How many Earth days does it take for Venus to orbit around the Sun once?",mutableListOf(
                                    Answer("395.3", false),
                                    Answer("224.7", true),
                                    Answer("134.5", false),
                                    Answer("413.4", false)
                                )
                            ),
                            Question(
                                "What is the other name Venus is known by?",mutableListOf(
                                    Answer("The Light Bringer", false),
                                    Answer("The Bright Angel", false),
                                    Answer("Morning Star", true),
                                    Answer("Little Sun", false)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "earth",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "How old is planet Earth?",mutableListOf(
                                    Answer("65 million years", false),
                                    Answer("225 million years", false),
                                    Answer("2.4 billion years", false),
                                    Answer("4.5 billion years", true)
                                )
                            ),
                            Question(
                                "What is the cause of the ocean tides?",mutableListOf(
                                    Answer("The movements of the tectonic plates", false),
                                    Answer("The gravitational interaction between Earth and the Moon", true),
                                    Answer("Difference in ocean water temperatures", false),
                                    Answer("Underwater volcanoes", false)
                                )
                            ),
                            Question(
                                "What percent of Earth's surface is occupied by land?",mutableListOf(
                                    Answer("13%", false),
                                    Answer("52%", false),
                                    Answer("43%", false),
                                    Answer("29%", true)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "mars",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What is the most common element found in the Mars atmosphere?",mutableListOf(
                                    Answer("Nitrogen", false),
                                    Answer("Carbon Monoxide", false),
                                    Answer("Carbon Dioxide", true),
                                    Answer("Hydrogen", false)
                                )
                            ),
                            Question(
                                "What causes the redness on the surface of Mars?",mutableListOf(
                                    Answer("Iron oxide (rust)", true),
                                    Answer("Red rocks and rock dust", false),
                                    Answer("Sulfur", false),
                                    Answer("Copper", false)
                                )
                            ),
                            Question(
                                "How many satellites does Mars have?",mutableListOf(
                                    Answer("0", false),
                                    Answer("1", false),
                                    Answer("2", true),
                                    Answer("3", false)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "jupiter",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What elements are found in the composition of Jupiter?",mutableListOf(
                                    Answer("Hydrogen and Helium", true),
                                    Answer("Hydrogen and Nitrogen", false),
                                    Answer("Phosphorus and Hydrogen", false),
                                    Answer("Helium and Nitrogen", false)
                                )
                            ),
                            Question(
                                "How many satellites are orbiting around Jupiter?",mutableListOf(
                                    Answer("47", false),
                                    Answer("63", false),
                                    Answer("79", true),
                                    Answer("85", false)
                                )
                            ),
                            Question(
                                "What is the great red spot on Jupiter?",mutableListOf(
                                    Answer("A dust cloud", false),
                                    Answer("A storm", true),
                                    Answer("A gas cloud", false),
                                    Answer("An amalgamation of gases", false)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "saturn",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What is the core of Saturn composed of?",mutableListOf(
                                    Answer("Compressed mix of gases", false),
                                    Answer("Molten copper and iron", false),
                                    Answer("Ice and rock", false),
                                    Answer("Iron-nickel and rock", true)
                                )
                            ),
                            Question(
                                "What gives Saturn its pale yellow hue?",mutableListOf(
                                    Answer("The color of its terrain", false),
                                    Answer("The ammonia crystals in its upper atmosphere", true),
                                    Answer("The dust in its atmosphere", false),
                                    Answer("The gases that its atmosphere is composed of", false)
                                )
                            ),
                            Question(
                                "What is the greatest wind speed registered on Saturn?",mutableListOf(
                                    Answer("524 km/h", false),
                                    Answer("1342 km/h", false),
                                    Answer("1800 km/h", true),
                                    Answer("2157 km/h", false)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "uranus",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What is the interior of Uranus composed of?",mutableListOf(
                                    Answer("Iron-nickel and rock", false),
                                    Answer("Ice and iron", false),
                                    Answer("Ice and rock", true),
                                    Answer("Copper and rock", false)
                                )
                            ),
                            Question(
                                "How many satellites does Uranus have?",mutableListOf(
                                    Answer("9", false),
                                    Answer("18", false),
                                    Answer("21", false),
                                    Answer("27", true)
                                )
                            ),
                            Question(
                                "What is the minimum temperature on Uranus?",mutableListOf(
                                    Answer("-147 °C", false),
                                    Answer("-189 °C", false),
                                    Answer("-224 °C", true),
                                    Answer("-274 °C", false)
                                )
                            )
                        )
                    )
                ),
                Pair(
                    "neptune",
                    PlanetData(
                        mutableListOf(
                            Question(
                                "What are the most common elements in the atmosphere of Neptune?",mutableListOf(
                                    Answer("Sulfur and Hydrogen", false),
                                    Answer("Hydrogen and Helium", true),
                                    Answer("Nitrogen and Helium", false),
                                    Answer("Nitrogen and Hydrogen", false)
                                )
                            ),
                            Question(
                                "How many satellites does Neptune have?",mutableListOf(
                                    Answer("7", false),
                                    Answer("14", true),
                                    Answer("19", false),
                                    Answer("23", false)
                                )
                            ),
                            Question(
                                "Who discovered Neptune first?",mutableListOf(
                                    Answer("Johann Galle", true),
                                    Answer("Clyde Tombaugh", false),
                                    Answer("Sir William Herschel", false),
                                    Answer("Galileo Galilei", false)
                                )
                            )
                        )
                    )
                )
            )
        )

        chooseQuestions()
    }

    fun chooseQuestions() {
        val planets: MutableList<String> = mutableListOf("mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune")

        var quizToShow: MutableList<Pair<String, Question>> = mutableListOf()

        for (i in 0..9) {
            var planet = planets[(0 until planets.size).random()]
            var planetQuestions = quiz.planetData.getValue(planet).questionsAnswers
            var question = planetQuestions[(0 until planetQuestions.size).random()]

            while (quizToShow.contains(Pair(planet, question))) {
                planet = planets[(0 until planets.size).random()]
                planetQuestions = quiz.planetData.getValue(planet).questionsAnswers
                question = planetQuestions[(0 until planetQuestions.size).random()]
            }
            quizToShow.add(Pair(planet, question))
        }

        setQuestion(quizToShow)
    }

    fun setQuestion(quizToShow: MutableList<Pair<String, Question>>) {
        if (answersList.childCount != 0) answersList.removeAllViews()
        val planetsBackgrounds: Map<String, Int> = mutableMapOf(
            Pair("mercury", R.drawable.mercury_space_background),
            Pair("venus", R.drawable.venus_space_background),
            Pair("earth", R.drawable.earth_space_background),
            Pair("mars", R.drawable.mars_space_background),
            Pair("jupiter", R.drawable.jupiter_space_background),
            Pair("saturn", R.drawable.saturn_space_background),
            Pair("uranus", R.drawable.uranus_space_background),
            Pair("neptune", R.drawable.neptune_space_background)
        )
        val planetsIMGs: Map<String, Int> = mutableMapOf(
            Pair("mercury", R.drawable.mercury),
            Pair("venus", R.drawable.venus),
            Pair("earth", R.drawable.earth),
            Pair("mars", R.drawable.mars),
            Pair("jupiter", R.drawable.jupiter),
            Pair("saturn", R.drawable.saturn),
            Pair("uranus", R.drawable.uranus),
            Pair("neptune", R.drawable.neptune)
        )
        val planetsColors: Map<String, Int> = mutableMapOf(
            Pair("mercury", R.color.mercuryList),
            Pair("venus", R.color.venusList),
            Pair("earth", R.color.earthList),
            Pair("mars", R.color.marsList),
            Pair("jupiter", R.color.jupiterList),
            Pair("saturn", R.color.saturnList),
            Pair("uranus", R.color.uranusList),
            Pair("neptune", R.color.neptuneList)
        )
        val planetsBtnsWrong: Map<String, Int> = mutableMapOf(
            Pair("mercury", R.drawable.mercury_button_wrong),
            Pair("venus", R.drawable.venus_button_wrong),
            Pair("earth", R.drawable.earth_button_wrong),
            Pair("mars", R.drawable.mars_button_wrong),
            Pair("jupiter", R.drawable.jupiter_button_wrong),
            Pair("saturn", R.drawable.saturn_button_wrong),
            Pair("uranus", R.drawable.uranus_button_wrong),
            Pair("neptune", R.drawable.neptune_button_wrong)
        )
        val planetsBtnsRight: Map<String, Int> = mutableMapOf(
            Pair("mercury", R.drawable.mercury_button_right),
            Pair("venus", R.drawable.venus_button_right),
            Pair("earth", R.drawable.earth_button_right),
            Pair("mars", R.drawable.mars_button_right),
            Pair("jupiter", R.drawable.jupiter_button_right),
            Pair("saturn", R.drawable.saturn_button_right),
            Pair("uranus", R.drawable.uranus_button_right),
            Pair("neptune", R.drawable.neptune_button_right)
        )
        val ansBtnList: MutableList<ButtonDataClass> = mutableListOf()

        mainQuizLayout.setBackgroundResource(planetsBackgrounds.getValue(quizToShow[qNum].first))

        val ans_container_shape = GradientDrawable()
        ans_container_shape.setColor(getColor(planetsColors.getValue(quizToShow[qNum].first)))
        ans_container_shape.cornerRadius = 25F
        ans_container_shape.alpha = 176
        answersList.background = ans_container_shape

        planetName.text = quizToShow[qNum].first.capitalize()
        planetImage.setImageResource(planetsIMGs.getValue(quizToShow[qNum].first))
        questionText.text = quizToShow[qNum].second.question

        for (i in 0..3) {
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.height = 135

            if (i == 0) params.setMargins(5, 10, 5, 20)
            if (i == 3) params.setMargins(5, 20, 5, 10)
            else params.setMargins(5, 20, 5, 20)

            val ans = ButtonDataClass(Button(this), quizToShow[qNum].second.answers[i].isRight)
            ans.btn.layoutParams = params
            ans.btn.setBackgroundResource(R.color.white)
            ans.btn.text = quizToShow[qNum].second.answers[i].text
            ans.btn.setTextColor(getColor(R.color.quizBtnTextColor))
            ans.btn.typeface = resources.getFont(R.font.myriadpro_regular)
            ans.btn.textSize = 16F

            ansBtnList.add(ans)

            answersList.addView(ans.btn)
        }

        for (ans in ansBtnList) {
            ans.btn.setOnClickListener {
                qNum++
                if (ans.right) {
                    correctAnss++
                    ans.btn.setBackgroundResource(planetsBtnsRight.getValue(quizToShow[qNum].first))
                }
                else {
                    ans.btn.setBackgroundResource(planetsBtnsWrong.getValue(quizToShow[qNum].first))
                    for (anss in ansBtnList) {
                        if (anss.right) {
                            anss.btn.setBackgroundResource(planetsBtnsRight.getValue(quizToShow[qNum].first))
                            break
                        }
                    }
                }

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
                nextBtn.setBackgroundColor(getColor(planetsColors.getValue(quizToShow[qNum].first)))
                nextBtn.background.alpha = 180
                nextBtn.setPadding(5, 3, 5, 3)
                nextBtn.setOnClickListener {
                    if (qNum == 9) {
                        var intnt = Intent(this, EndGameActivity::class.java)
                        intnt.putExtra("score", correctAnss.toString())
                        startActivity(intnt)
                    }
                    else setQuestion(quizToShow)
                }

                answersList.addView(nextBtn)
            }
        }
    }
}
