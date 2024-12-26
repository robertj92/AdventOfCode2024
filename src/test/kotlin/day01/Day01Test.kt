package day01

import de.rjunklewitz.day01.Day01
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class Day01Test {

    @Test
    fun testSmallest() {
        val day01 = Day01()
        val input = listOf(1, 2, 3)
        val smallest = day01.smallest(input)
        assertEquals(1, smallest)
    }

    @Test
    fun testConvertToLocationGroups() {
        val day01 = Day01()
        val input = listOf(
            "3   4",
            "4   2",
            "2   5"
        )

        val (leftList, rightList) = day01.convertToLocationGroups(input)

        assertEquals(listOf(2, 3, 4), leftList)
        assertEquals(listOf(2, 4, 5), rightList)
    }

    @Test
    fun testProcess() {
        val day01 = Day01()
        val input = listOf(
            "3   4",
            "4   3",
            "2   5",
            "1   3",
            "3   9",
            "3   3"
        )

        val distance = day01.process(input)
        val sumOfOccurrences = day01.partTwo(input)

        assertEquals(11, distance)
        assertEquals(31, sumOfOccurrences)
    }
}