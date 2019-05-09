package org.tukanoid.projectapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_end_game.*

class EndGameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)

        Log.d(null, intent.getStringExtra("score"))

        scoreTxt.text = (intent.getStringExtra("score") + "/10")

        quitBtn.setOnClickListener {
            finishAffinity()
        }

        restartBtn.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}
