package fr.deroffal.aoc2025

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class Day02Test {

    val testInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
            "824824821-824824827,2121212118-2121212124"

    @Test
    fun `is invalid`() {
        assertTrue(isRepeatingTwice(11))
        assertTrue(isRepeatingTwice(22))
        assertTrue(isRepeatingTwice(99))
        assertTrue(isRepeatingTwice(1010))
        assertTrue(isRepeatingTwice(1188511885))
        assertTrue(isRepeatingTwice(222222))
        assertTrue(isRepeatingTwice(446446))
        assertTrue(isRepeatingTwice(38593859))
    }

    @Test
    fun `is valid`() {
        assertFalse(isRepeatingTwice(111))
        assertFalse(isRepeatingTwice(1001))
    }

    @Test
    fun `count invalid in range`(){
        assertEquals(2, IdRange("11-22").range.count { isRepeatingTwice(it) })
        assertEquals(1, IdRange("95-115").range.count { isRepeatingTwice(it) })
        assertEquals(1, IdRange("998-1012").range.count { isRepeatingTwice(it) })
        assertEquals(1, IdRange("1188511880-1188511890").range.count { isRepeatingTwice(it) })
    }

    @Test
    fun `part1 - verify example`(){
        val day02 = Day02(testInput)
        assertEquals(1227775554, day02.part1())
    }

    @Test
    fun `part1 - verify`(){
        val day02Input = File(ClassLoader.getSystemResource("day02.txt").toURI()).readText().trim()
        val day02 = Day02(day02Input)
        assertEquals(37314786486, day02.part1())
    }

    @Test
    fun isRepeating(){
        //part 1 example
        assertTrue(isRepeating(11))
        assertTrue(isRepeating(22))
        assertTrue(isRepeating(99))
        assertTrue(isRepeating(1010))
        assertTrue(isRepeating(1188511885))
        assertTrue(isRepeating(222222))
        assertTrue(isRepeating(446446))
        assertTrue(isRepeating(38593859))

        assertTrue(isRepeating(111))
        assertFalse(isRepeating(1001))

        //
        assertTrue(isRepeating(1010))
        assertTrue(isRepeating(999))
        assertTrue(isRepeating(565656))
        assertTrue(isRepeating(824824824))
        assertTrue(isRepeating(2121212121))
    }

    @Test
    fun `part2 - verify example`(){
        val day02 = Day02(testInput)
        assertEquals(4174379265, day02.part2())
    }
}
