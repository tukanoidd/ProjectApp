package org.tukanoid.projectapp.quiz

data class Question(
    val question: String,
    val answers: MutableList<Answer>
)