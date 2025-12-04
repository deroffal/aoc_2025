package fr.deroffal.aoc2025

import java.io.File

val day04Input = File(ClassLoader.getSystemResource("day04.txt").toURI()).readLines().filterNot { it.isBlank() }


class Day04(input: List<String>) {
    val rolls = (0..<input.size).flatMap { y ->
        (0..<input[y].length).filter { x -> input[y][x] == '@' }.map { x -> x to y }
    }

    fun part1() = rolls.count { roll -> countAdjacent(roll) < 4 }

    private fun countAdjacent(pair: Pair<Int, Int>): Int =
        (-1..1).sumOf { b ->
            (-1..1).count { a ->
                val x = pair.first + a
                val y = pair.second + b
                return@count if (x < 0 || y < 0) false // out of bounds
                else pair != x to y // not itself
                        && rolls.contains(x to y)
            }
        }
}

fun main() {
    val day04 = Day04(day04Input)
    println(
        """
        Part 1: ${day04.part1()}
    """.trimIndent()
    )
}
