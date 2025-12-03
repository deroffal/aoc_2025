package fr.deroffal.aoc2025

import java.io.File

class Banks(val banks: List<Bank>) {
    constructor(input: String) : this(input.toCharArray().mapIndexed { index, char -> Bank(char.digitToInt(), index) })

    fun getMaxVoltage(): Int {
        var mostPowerful = banks.maxBy { it.voltage }

        if (mostPowerful.position == banks.size - 1) {
            mostPowerful = banks.dropLast(1).maxBy { it.voltage }
        }

        return 10 * mostPowerful.voltage +
                banks.filter { it.position > mostPowerful.position }
                    .maxOf { it.voltage }
    }
}

class Bank(val voltage: Int, val position: Int) {

}

val day03Input = File(ClassLoader.getSystemResource("day03.txt").toURI()).readLines().filterNot { it.isBlank()  }

class Day03(val inputs: List<String>) {
    fun part1() = inputs.sumOf { Banks(it).getMaxVoltage() }
}

fun main() {
    val day03 = Day03(day03Input)
    println("""
        part 1 : ${day03.part1()}
    """.trimIndent())
}
