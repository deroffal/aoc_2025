package fr.deroffal.aoc2025

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {

    val inputs = listOf(
        "987654321111111",
        "811111111111119",
        "234234234234278",
        "818181911112111"
    )

    @Test
    fun `create bank from input`() {
        val battery = Battery("987654321111111").banks

        assertEquals(15, battery.size)

        val banks1 = battery[0]
        assertEquals(9, banks1.voltage)
        assertEquals(0, banks1.position)

        val banks2 = battery[1]
        assertEquals(8, banks2.voltage)
        assertEquals(1, banks2.position)

    }

    @Nested
    inner class GetMaxVoltage {

        @Test
        fun `when banks are sorted`() {
            assertEquals(98, Battery("987654321111111").getMaxVoltage())
            assertEquals(98, Battery("987654321111111").getMaxVoltage(2))
            assertEquals(92, Battery("818181911112111").getMaxVoltage())
            assertEquals(92, Battery("818181911112111").getMaxVoltage(2))
        }

        @Test
        fun `when most powerful is last`() {
            assertEquals(89, Battery("811111111111119").getMaxVoltage())
            assertEquals(89, Battery("811111111111119").getMaxVoltage(2))
            assertEquals(78, Battery("234234234234278").getMaxVoltage())
            assertEquals(78, Battery("234234234234278").getMaxVoltage(2))
        }

    }

    @Test
    fun `part 1 - example`() {
        val day03 = Day03(inputs)
        assertEquals(357, day03.part1())
    }

    val day03Input = File(ClassLoader.getSystemResource("day03.txt").toURI()).readLines().filterNot { it.isBlank() }

    @Test
    fun `part 1 - input`() {
        val day03 = Day03(day03Input)
        assertEquals(17403, day03.part1())
    }

    @Nested
    inner class GetMaxVoltageWithSize{

        @Test
        fun `when banks are sorted - size 2`() {
            assertEquals(98L, Battery("987654321111111").getMaxVoltage(2))
        }

        @Test
        fun `when banks are sorted - size 3`() {
            assertEquals(987L, Battery("987654321111111").getMaxVoltage(3))
        }

        @Test
        fun `when banks are sorted - size 12`() {
            assertEquals(987654321111L, Battery("987654321111111").getMaxVoltage(12))
        }

        @Test
        fun `when banks are not sorted - size 12`() {
            assertEquals(811111111119L, Battery("811111111111119").getMaxVoltage(12))
            assertEquals(434234234278L, Battery("234234234234278").getMaxVoltage(12))
            assertEquals(888911112111L, Battery("818181911112111").getMaxVoltage(12))
        }
    }

    @Test
    fun `part 2 - example`() {
        val day03 = Day03(inputs)
        assertEquals(3121910778619L, day03.part2())
    }

    @Test
    fun `part 2`() {
        val day03 = Day03(day03Input)
        assertEquals(173416889848394L, day03.part2())
    }
}
