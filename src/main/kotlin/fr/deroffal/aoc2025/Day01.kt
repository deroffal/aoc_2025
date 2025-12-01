package fr.deroffal.aoc2025

import java.io.File
import kotlin.math.abs

data class Movement(val position: Int, val hitCount: Int)

sealed interface Rotation {
    fun move(current: Int): Movement
}

private const val SIZE = 100

data class MoveRight(val distance: Int) : Rotation {
    override fun move(current: Int): Movement {
        val position = (current + distance).mod(SIZE)
        val hits = (current + distance) / SIZE
        return Movement(position, hits)
    }
}

data class MoveLeft(val distance: Int) : Rotation {
    override fun move(current: Int): Movement {
        val i = current - distance
        val position = i.mod(SIZE)

        if (i > 0) {
            //if we are still > 0 no hit
            return Movement(position, 0)
        }

        //moving left, from -1 to -99 it already counts as 1
        val hits = (abs(i) + SIZE) / SIZE

        if (current == 0) {
            //if we are already at 0, don't take the first hit into account (it's just the 0)
            return Movement(position, hits - 1)
        }

        return Movement(position, hits)
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
        .fold(50) { acc, rotation -> rotation.move(acc).position }


    fun part1() = input.map { fromInput(it) }
        .runningFold(50) { acc, rotation ->
            rotation.move(acc).position
        }.count { it == 0 }


    fun part2(): Int {
        var count = 0

        input.map { fromInput(it) }
            .runningFold(50) { acc, rotation ->
                val movement = rotation.move(acc)
                count += movement.hitCount
                return@runningFold movement.position
            }
        return count
    }

}

fun main() {
    val day01 = Day01(day01Input)
    println(
        """
        part 1 : ${day01.part1()}
        part 2 : ${day01.part2()}
    """.trimIndent()
    )
}


fun readContentAsList(filename: String) =
    File(ClassLoader.getSystemResource(filename).toURI()).readLines().filterNot { it.isEmpty() }
