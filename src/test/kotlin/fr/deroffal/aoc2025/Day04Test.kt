package fr.deroffal.aoc2025

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day04Test {

    private val testInput = """
        ..@@.@@@@.
        @@@.@.@.@@
        @@@@@.@.@@
        @.@@@@..@.
        @@.@@@@.@@
        .@@@@@@@.@
        .@.@.@.@@@
        @.@@@.@@@@
        .@@@@@@@@.
        @.@.@@@.@.
    """.trimIndent()

    @Test
    fun parseInput(){
        val day04 = Day04(testInput.lines())
        val rollCount = testInput.toCharArray().count { it == '@' }
        assertEquals(rollCount, day04.rolls.size)
    }

    @Test
    fun `part 1 - example`() {
        val day04 = Day04(testInput.lines())
        assertEquals(13, day04.part1())
    }

    @Test
    fun `part 1 - solution`() {
        val day04 = Day04(day04Input)
        assertEquals(1486, day04.part1())
    }

}
