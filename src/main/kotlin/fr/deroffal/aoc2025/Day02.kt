package fr.deroffal.aoc2025

import java.io.File

class IdRange(val range: LongRange) {

    constructor(input: String) : this(input.split("-").let { LongRange(it[0].toLong(), it[1].toLong()) })

    fun countRepeatingTwice()= range.filter { isRepeatingTwice(it) }.sum()
    fun countRepeating()= range.filter { isRepeating(it) }.sum()
}

fun isRepeatingTwice(id: Long): Boolean {
    val toString = id.toString()
    if (toString.length % 2 != 0) return false

    val half = toString.length / 2

    return toString.take(half) == toString.substring(half)
}

fun isRepeating(id: Long): Boolean {
        val toString = id.toString()
        val length = toString.length

        return  (1..length / 2).any { toString.chunked(it).toSet().size == 1 }
}

val day02Input = File(ClassLoader.getSystemResource("day02.txt").toURI()).readText().trim()

class Day02(val input: String) {
    fun part1() = input.split(",")
        .map { range -> IdRange(range) }
        .sumOf { it.countRepeatingTwice() }

    fun part2() = input.split(",")
        .map { range -> IdRange(range) }
        .sumOf { it.countRepeating() }
}

fun main(){
    val day02 = Day02(day02Input)
    println("""
        part 1 : ${day02.part1()}
        part 2 : ${day02.part2()}
    """.trimIndent())
}
