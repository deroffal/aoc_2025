package fr.deroffal.aoc2025

import java.io.File

class IdRange(val range: LongRange) {

    constructor(input: String) : this(input.split("-").let { LongRange(it[0].toLong(), it[1].toLong()) })

    fun countRepeatTwice()= range.filter { repeatTwice(it) }.sum()
}

fun repeatTwice(id: Long): Boolean {
    val toString = id.toString()
    if (toString.length % 2 != 0) return false

    val half = toString.length / 2

    return toString.take(half) == toString.substring(half)
}

val day02Input = File(ClassLoader.getSystemResource("day02.txt").toURI()).readText().trim()

class Day02(val input: String) {
    fun part1() = input.split(",")
        .map { range -> IdRange(range) }
        .sumOf { it.countRepeatTwice() }
}

fun main(){
    println("""
        part 1 : ${Day02(day02Input).part1()}
    """.trimIndent())
}
