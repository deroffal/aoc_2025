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
        assertTrue(repeatTwice(11))
        assertTrue(repeatTwice(22))
        assertTrue(repeatTwice(99))
        assertTrue(repeatTwice(1010))
        assertTrue(repeatTwice(1188511885))
        assertTrue(repeatTwice(222222))
        assertTrue(repeatTwice(446446))
        assertTrue(repeatTwice(38593859))
    }

    @Test
    fun `is valid`() {
        assertFalse(repeatTwice(111))
        assertFalse(repeatTwice(1001))
    }

    @Test
    fun `count invalid in range`(){
        assertEquals(2, IdRange("11-22").range.count { repeatTwice(it) })
        assertEquals(1, IdRange("95-115").range.count { repeatTwice(it) })
        assertEquals(1, IdRange("998-1012").range.count { repeatTwice(it) })
        assertEquals(1, IdRange("1188511880-1188511890").range.count { repeatTwice(it) })
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


}
