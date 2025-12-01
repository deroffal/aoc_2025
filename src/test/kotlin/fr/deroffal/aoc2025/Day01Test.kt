package fr.deroffal.aoc2025

import org.junit.jupiter.api.Nested
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

    @Nested
    inner class MoveLeftTest {
        @Test
        fun `Move left, simple case`(){
            val movement = fromInput("L8").move(50)
            assertEquals(42, movement.position)
            assertEquals(0, movement.hitCount)
        }

        @Test
        fun `Move left, reach 0 once`(){
            val movement = fromInput("L8").move(8)
            assertEquals(0, movement.position)
            assertEquals(1, movement.hitCount)
        }

        @Test
        fun `Move left, reach 0 twice`(){
            val movement = fromInput("L108").move(8)
            assertEquals(0, movement.position)
            assertEquals(2, movement.hitCount)
        }

        @Test
        fun `Move left, reach 0 twice, and remaining`(){
            val movement = fromInput("L118").move(8)
            assertEquals(90, movement.position)
            assertEquals(2, movement.hitCount)
        }

        @Test
        fun `Move left, already at 0 just decreasing`(){
            val movement = fromInput("L1").move(0)
            assertEquals(99, movement.position)
            assertEquals(0, movement.hitCount)
        }

        @Test
        fun `Move left, already at 0 with one hit`(){
            val movement = fromInput("L101").move(0)
            assertEquals(99, movement.position)
            assertEquals(1, movement.hitCount)
        }
    }

    @Test
    fun `MoveRight move the cursor to the right`() {
        val movement1 = fromInput("R14").move(0)
        assertEquals(14, movement1.position)
        assertEquals(0, movement1.hitCount)

        val movement2 = fromInput("R48").move(52)
        assertEquals(0, movement2.position)
        assertEquals(1, movement2.hitCount)

        val movement3 = fromInput("R1000").move(50)
        assertEquals(50, movement3.position)
        assertEquals(10, movement3.hitCount)

        val movement4 = fromInput("R599").move(0)
        assertEquals(99, movement4.position)
        assertEquals(5, movement4.hitCount)
    }


    @MethodSource("moveParameters")
    @ParameterizedTest
    fun `part1 - examples`( current: Int,  input: String,  expected: Int) {
        val value = fromInput(input).move(current).position
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

    val exampleInput = listOf(
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

    @Test
    fun `part1 - verify calculation`() {
        val day01 = Day01(exampleInput)
        assertEquals(32, day01.getlast())
    }

    @Test
    fun `part1 - verify example`() {
        val day01 = Day01(exampleInput)
        assertEquals(3, day01.part1())
    }

    @Test
    fun `part1 - solution`(){
        val day01 = Day01(day01Input)
        assertEquals(1105, day01.part1())
    }

    @Test
    fun `part2 - verify example`() {
        val day01 = Day01(exampleInput)
        assertEquals(6, day01.part2())
    }

    @Test
    fun `part2 - solution`() {
        val day01 = Day01(day01Input)
        assertEquals(6599, day01.part2())
    }

}
