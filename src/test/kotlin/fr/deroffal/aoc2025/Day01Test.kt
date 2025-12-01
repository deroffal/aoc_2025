package fr.deroffal.aoc2025

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Day01Test {

    @Test
    fun `create the correct instance of Rotation from an input`() {
        val l10 = fromInput("L10")
        assert(l10 is MoveLeft)
        val moveLeft = l10 as MoveLeft
        assertEquals(10, moveLeft.distance)

        val r7 = fromInput("R7")
        assert(r7 is MoveRight)
        val moveRight = r7 as MoveRight
        assertEquals(7, moveRight.distance)
    }

    @Test
    fun `MoveLeft move the cursor to the left`() {
        val value: Int = fromInput("L30").move(82)
        assertEquals(52, value)
    }

    @Test
    fun `MoveRight move the cursor to the right`() {
        val value: Int = fromInput("R14").move(0)
        assertEquals(14, value)
    }

    @Test
    fun `MoveLeft restarts before 0 to 99`() {
        val value: Int = fromInput("L68").move(50)
        assertEquals(82, value)
    }

    @Test
    fun `MoveRight restarts after 0 to 1`() {
        val value: Int = fromInput("R48").move(52)
        assertEquals(0, value)
    }

    @MethodSource("moveParameters")
    @ParameterizedTest
    fun `part1 - examples`( current: Int,  input: String,  expected: Int) {
        val value: Int = fromInput(input).move(current)
        assertEquals(expected, value)
    }

    fun moveParameters(): Stream<Arguments> = Stream.of(
        Arguments.of(50, "L68", 82),
        Arguments.of(82, "L30", 52),
        Arguments.of(52, "R48", 0),
        Arguments.of(0, "L5", 95),
        Arguments.of(95, "R60", 55),
        Arguments.of(55, "L55", 0),
        Arguments.of(0, "L1", 99),
        Arguments.of(99, "L99", 0),
        Arguments.of(0, "R14", 14),
        Arguments.of(14, "L82", 32),
        Arguments.of(99, "R1", 0),
        Arguments.of(0, "L1", 99),
    )

    @Test
    fun `part1 - verify calculation`() {
        val input = listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
        )
        val day01 = Day01(input)
        assertEquals(32, day01.getlast())
    }


    @Test
    fun `part1 - verify example`() {
        val input = listOf(
            "L68",
            "L30",
            "R48",
            "L5",
            "R60",
            "L55",
            "L1",
            "L99",
            "R14",
            "L82"
        )
        val day01 = Day01(input)
        assertEquals(3, day01.part1())
    }

    @Test
    fun `part1 - solution`(){
        val day01 = Day01(day01Input)
        assertEquals(1105, day01.part1())
    }

}
