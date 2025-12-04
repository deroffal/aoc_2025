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

    val day04 = Day04(day04Input)

    @Test
    fun `part 1 - solution`() {
        assertEquals(1486, day04.part1())
    }

    @Test
    fun `part 2 - example`() {
        val day04 = Day04(testInput.lines())
        assertEquals(43, day04.part2())
    }

    @Test
    fun `part 2 - solution`() {
        assertEquals(9024, day04.part2())
    }
}
