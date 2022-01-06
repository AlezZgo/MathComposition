package com.example.mathcomposition.domain.entity

data class Question(
    val sum: Int,
    val visiblenumber: Int,
    val options: List<Int>
)