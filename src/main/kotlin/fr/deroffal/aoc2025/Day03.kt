package fr.deroffal.aoc2025

import java.io.File
import kotlin.math.pow

class Battery(val banks: List<Bank>) {
    constructor(input: String) : this(
        input.toCharArray()
            .mapIndexed { index, char -> Bank(char.digitToInt(), index) }
    )

    //keeping for part 1, but can be replaced with getMaxVoltage(2)
    fun getMaxVoltage(): Int {
        var mostPowerful = banks.maxBy { it.voltage }

        if (mostPowerful.position == banks.size - 1) {
            mostPowerful = banks.dropLast(1).maxBy { it.voltage }
        }

        return 10 * mostPowerful.voltage +
                banks.filter { it.position > mostPowerful.position }
                    .maxOf { it.voltage }
    }

    fun getMaxVoltage(size: Int): Long {
        var battery = this
        var voltage = 0L

        for (i in size - 1 downTo 0) {
            val mostPowerful = battery.banks
                .take(battery.banks.size - i) // candidates must leave enough banks for the remaining positions
                .maxBy { it.voltage }
            voltage += mostPowerful.voltage * 10.0.pow(i.toDouble()).toLong()
            battery = battery.dropBefore(mostPowerful.position) // drop used banks and those before
        }

        return voltage
    }

    fun dropBefore(position: Int) = banks.filterNot { it.position <= position }
        .mapIndexed { index, bank -> Bank(bank.voltage, index) }
        .run { Battery(this) }

    override fun toString() = banks.map { it.voltage }.joinToString("")
}

data class Bank(val voltage: Int, val position: Int)

val day03Input = File(ClassLoader.getSystemResource("day03.txt").toURI()).readLines().filterNot { it.isBlank() }

class Day03(val inputs: List<String>) {
    fun part1() = inputs.sumOf { Battery(it).getMaxVoltage() }
    fun part2() = inputs.sumOf { Battery(it).getMaxVoltage(12) }
}

fun main() {
    val day03 = Day03(day03Input)
    println(
        """
        part 1 : ${day03.part1()}
        part 2 : ${day03.part2()}
    """.trimIndent()
    )
}
