package day02

import de.rjunklewitz.day02.Day02
import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {

    private val day02 = Day02()

    @Test
    fun testPartOne() {
        val input = listOf(
            "1 2 3",
            "1 3 2",
            "3 2 1",
            "1 5 7"
        )
        val amountOfSafeReactors = day02.partOne(input)

        assertEquals(2, amountOfSafeReactors)
    }

    @Test
    fun testPartTwo() {
        val input= listOf(
            "7 6 4 2 1",
            "1 2 7 8 9",
            "9 7 6 2 1",
            "1 3 2 4 5",
            "8 6 4 4 1",
            "1 3 6 7 9",
            "1 2 3 4 4",
            "7 1 2 3 4"
        )

        val amountOfSafeReactors = day02.partTwo(input)
        assertEquals(6, amountOfSafeReactors)
    }
}