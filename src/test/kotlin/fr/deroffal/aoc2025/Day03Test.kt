package fr.deroffal.aoc2025

import org.junit.jupiter.api.Nested
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
        val banks = Banks("987654321111111").banks

        assertEquals(15, banks.size)

        val banks1 = banks[0]
        assertEquals(9, banks1.voltage)
        assertEquals(0, banks1.position)

        val banks2 = banks[1]
        assertEquals(8, banks2.voltage)
        assertEquals(1, banks2.position)

    }

    @Nested
    inner class GetMaxVoltage {

        @Test
        fun `when banks are sorted`() {
            assertEquals(98, Banks("987654321111111").getMaxVoltage())
            assertEquals(92, Banks("818181911112111").getMaxVoltage())
        }

        @Test
        fun `when most powerful is last`() {
            assertEquals(89, Banks("811111111111119").getMaxVoltage())
            assertEquals(78, Banks("234234234234278").getMaxVoltage())
        }

    }

    @Test
    fun `part 1`() {
        val day03 = Day03(inputs)
        assertEquals(357, day03.part1())
    }
}
