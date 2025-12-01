package fr.deroffal.aoc2025

import java.io.File

sealed interface Rotation {
    fun move(current: Int): Int
}

data class MoveRight(val distance: Int) : Rotation {
    override fun move(current: Int): Int {
        return (current + distance).mod(100)
    }
}

data class MoveLeft(val distance: Int) : Rotation {
    override fun move(current: Int): Int {
        return (current - distance).mod(100)
    }
}

fun fromInput(input: String): Rotation {
    val direction = input.take(1)
    val distance = input.substring(1).toInt()
    return when (direction) {
        "R" -> {
            MoveRight(distance)
        }

        "L" -> {
            MoveLeft(distance)
        }

        else -> {
            throw IllegalArgumentException("invalid direction : $direction")
        }
    }
}

val day01Input = readContentAsList("day01.txt")

class Day01(val input: List<String>) {

    fun getlast() = input
        .map { fromInput(it) }
        .fold(50) { acc, rotation -> rotation.move(acc) }


    fun part1(): Int {
        return input.map { fromInput(it) }
            .runningFold(50) { acc, rotation ->
                rotation.move(acc)
            }.count { it == 0 }
    }

}

fun main() {
    val day01 = Day01(day01Input)
    println(
        """
        part 1 : ${day01.part1()}
    """.trimIndent()
    )
}


fun readContentAsList(filename: String) =
    File(ClassLoader.getSystemResource(filename).toURI()).readLines().filterNot { it.isEmpty() }
